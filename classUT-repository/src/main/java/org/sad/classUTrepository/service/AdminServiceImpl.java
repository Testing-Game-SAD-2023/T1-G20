package org.sad.classUTrepository.service;

import org.sad.classUTrepository.entity.Admin;
import org.sad.classUTrepository.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public void save(Admin item) {
		adminRepository.save(item);
	}

	@Override
	public Admin getAdminbyId(int id) {
		return adminRepository.findByid(id);
	}

	@Override
	public Admin update(Admin item) {
		
		Admin updateAdmin = adminRepository.findById(item.getId()).get();
		//TODO: updateAdmin.set... = item.get ...
		return adminRepository.save(updateAdmin);
	}

	@Override
	public void delete(int id) {
		Admin deleteAdmin = adminRepository.findById(id).get();
		adminRepository.delete(deleteAdmin);
	}

}
