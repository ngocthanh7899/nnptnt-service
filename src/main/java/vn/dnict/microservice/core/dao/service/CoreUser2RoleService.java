package vn.dnict.microservice.core.dao.service;

import java.util.List;
import java.util.Optional;

import vn.dnict.microservice.core.dao.model.CoreUser2Role;

public interface CoreUser2RoleService {
	public CoreUser2Role save(CoreUser2Role coreUser2Role);

	public void deleteById(Long id);

	public boolean existsById(Long id);

	public Optional<CoreUser2Role> findById(Long id);

	public List<CoreUser2Role> findByRoleIdAndDaXoa(Long roleId, Boolean daXoa);

	public List<CoreUser2Role> findByRoleIdAndUserId(Long roleId, Long userId);

	public int setFixedDaXoaForRoleId(Boolean daXoa, Long roleId);
	
	public int setFixedDaXoaForUserId(Boolean daXoa, Long userId);

	public List<CoreUser2Role> findByUserIdAndDaXoa(Long userId, Boolean daXoa);

}
