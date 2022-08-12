package uy.edu.cei.megacalendar.services;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uy.edu.cei.megacalendar.controllers.request.UserCreateRequest;
import uy.edu.cei.megacalendar.controllers.response.UserResponse;
import uy.edu.cei.megacalendar.exceptions.InvalidPasswordFormatException;
import uy.edu.cei.megacalendar.mappers.UserMapper;
import uy.edu.cei.megacalendar.models.UserModel;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> user = this.userMapper.findByUsername(username);
        return this.mapToUserDetails(
                user.orElseThrow(
                        () -> new UsernameNotFoundException(format("username %s not found", username))
                ));
    }

    public boolean createUser(UserCreateRequest userCreateRequest) throws InvalidPasswordFormatException {
        UserModel userModel = UserModel.builder()
                .username(userCreateRequest.getUsername())
                .password(passwordEncoder.encode(userCreateRequest.getPassword()))
                .build();

        int passwordLength = userModel.getPassword().length();
        if (passwordLength < 8 || passwordLength > 70) {
            throw new InvalidPasswordFormatException();
        }

        boolean success = this.userMapper.insertUser(userModel);
        return success;
    }

    public UserModel fetchUserById(final Long id) {
        return userMapper.fetchUserById(id);
    }

    private UserDetails mapToUserDetails(final UserModel userModel) {
        return new UserDetails() {
            private static final List<GrantedAuthority> ROLE_USER = Collections
                    .unmodifiableList(AuthorityUtils.createAuthorityList("ROLE_USER"));

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return ROLE_USER;
            }

            @Override
            public String getPassword() {
                return userModel.getPassword();
            }

            @Override
            public String getUsername() {
                return userModel.getUsername();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }

    public List<UserResponse> fetchAll(final Integer limit) {
        return Collections.emptyList();
    }
}
