package store.management.store_system.service.account;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import store.management.store_system.dto.AppResponse;
import store.management.store_system.dto.UpdateProfile;
import store.management.store_system.dto.UserDto;
import store.management.store_system.entity.User;
import store.management.store_system.exception.ApiException;
import store.management.store_system.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService{
    private final UserRepository userRepository;
    @Override
    public AppResponse<Map<String, Object>> getAllStaff(Pageable pageable) {
        Page<UserDto> usersData = userRepository.findAll(pageable).map(user -> new UserDto(user));

        Map<String, Object> page = Map.of(
                "page", usersData.getNumber(),
                "totalPages", usersData.getTotalPages(),
                "totalElements", usersData.getTotalElements(),
                "size", usersData.getSize(),
                "content", usersData
        );


        return new AppResponse<>("success", page);
    }

    @Override
    @Transactional
    public AppResponse<String> updateProfile(UpdateProfile updateProfile, long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ApiException("not found"));

        updateProfile.getFirstName().ifPresent(user::setFirstName);
        updateProfile.getLastName().ifPresent(user::setLastName);

        userRepository.save(user);
        return new AppResponse<>(0, "successful updating");
    }
}
