package vn.dnict.microservice.core.dao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.dnict.microservice.core.dao.model.CoreRole2ChucNang;

@Service
@Transactional
public class CoreRole2ChucNangServiceImpl implements CoreRole2ChucNangService {
	@Autowired
	private CoreRole2ChucNangRepo repo;

	public CoreRole2ChucNang save(CoreRole2ChucNang coreRole2ChucNang) {
		return repo.save(coreRole2ChucNang);
	}

	public void deleteById(Long id) {
		repo.deleteById(id);
	}

	public Optional<CoreRole2ChucNang> findById(Long id) {
		return repo.findById(id);
	}

	public boolean existsById(Long id) {
		return repo.existsById(id);
	}

	public List<CoreRole2ChucNang> findByRoleIdAndDaXoa(Long roleId, Boolean daXoa) {
		return repo.findByRoleIdAndDaXoa(roleId, daXoa);
	}

	public int setFixedDaXoaForRoleId(Boolean daXoa, Long roleId) {
		return repo.setFixedDaXoaForRoleId(daXoa, roleId);
	}

	public List<CoreRole2ChucNang> findByRoleIdAndChucNangId(Long roleId, Long chucNangId) {
		return repo.findByRoleIdAndChucNangId(roleId, chucNangId);
	}

	public List<CoreRole2ChucNang> findByChucNangIdAndDaXoa(Long chucNangId, Boolean daXoa) {
		return repo.findByChucNangIdAndDaXoa(chucNangId, daXoa);
	}

}
