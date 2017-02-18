/**
 * This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contacts.contact_management.dao.ImageDAO;
import com.contacts.contact_management.model.Image;
import com.contacts.utils.MyLogger;

/**
 * @author JavaTraining
 *
 */
@Service
@Transactional
public class ImageServiceImpl implements ImageService {

	private Logger log = MyLogger.getLogger();

	@Autowired
	private ImageDAO imageDAO;

	@Override
	public Image getImageById(final Long id) {
		log.info("In getImageById method.");
		return imageDAO.findOne(id);
	}

	@Override
	public List<Image> getAllImages() {
		log.info("In getAllImages method.");
		return imageDAO.findAll();
	}

	@Override
	public Image createImage(final Image image) {
		log.info("In createImage method");
		return imageDAO.save(image);
	}

	@Override
	public Image updateImage(final Image image) {
		log.info("In updateImage method");
		return imageDAO.save(image);
	}

	@Override
	public void deleteImage(final Long id) {
		log.info("In deleteImage method");
		imageDAO.delete(id);
	}

}
