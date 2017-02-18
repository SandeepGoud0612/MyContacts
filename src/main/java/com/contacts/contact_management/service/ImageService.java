/**
 * This source code is property of MyContacts Project Team.
 */
package com.contacts.contact_management.service;

import java.util.List;

import com.contacts.contact_management.model.Image;

/**
 * @author Sandeep
 *
 */
public interface ImageService {

	/**
	 * Gets the image by id.
	 * 
	 * @param id
	 * @return image
	 */
	Image getImageById(Long id);

	/**
	 * Gets all images.
	 * 
	 * @return List<Image>
	 */
	List<Image> getAllImages();

	/**
	 * Creates image
	 * 
	 * @param image
	 * @return image
	 */
	Image createImage(Image image);

	/**
	 * Updates image.
	 * 
	 * @param image
	 * @return image
	 */
	Image updateImage(Image image);

	/**
	 * Deletes image.
	 * 
	 * @param id
	 */
	void deleteImage(Long id);

}
