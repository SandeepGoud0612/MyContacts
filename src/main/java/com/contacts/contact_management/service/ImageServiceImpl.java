/**
 * This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contacts.contact_management.dao.ImageDAO;
import com.contacts.contact_management.model.Image;

/**
 * @author JavaTraining
 *
 */
@Service
@Transactional
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageDAO imageDAO;

	@Override
	public Image getImageById(final Long id) {
		// TODO Auto-generated method stub
		return imageDAO.findOne(id);
	}

	@Override
	public List<Image> getAllImages() {
		// TODO Auto-generated method stub
		return imageDAO.findAll();
	}

	@Override
	public Image createImage(final Image image) {
		// TODO Auto-generated method stub
		return imageDAO.save(image);
	}

	@Override
	public Image updateImage(final Image image) {
		// TODO Auto-generated method stub
		return imageDAO.save(image);
	}

	@Override
	public void deleteImage(final Long id) {
		// TODO Auto-generated method stub
		imageDAO.delete(id);
	}

}
