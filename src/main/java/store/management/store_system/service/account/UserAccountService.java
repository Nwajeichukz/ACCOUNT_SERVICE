package store.management.store_system.service.account;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import store.management.store_system.dto.AppResponse;
import store.management.store_system.dto.UpdateProfile;

import java.util.Map;

public interface UserAccountService {
    AppResponse<Map<String, Object>> getAllStaff(Pageable pageable);

    AppResponse<String> updateProfile(UpdateProfile updateProfile, long id);

}
