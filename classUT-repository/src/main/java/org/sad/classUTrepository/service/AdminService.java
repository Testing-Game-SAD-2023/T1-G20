package org.sad.classUTrepository.service;

import org.sad.classUTrepository.entity.Admin;

public interface AdminService {

	void save(Admin item);
	Admin getAdminbyId(int id);
	Admin update(int id, String newName, String newSurname, String newUser, String newPsw);
	void delete(int id);
}
