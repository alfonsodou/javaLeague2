/**
 * 
 */
package org.javahispano.javaleague.server.domain;

import java.io.Serializable;
import java.util.logging.Logger;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * @author adou
 * 
 */
@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(User.class.getName());

	@Id
	private Long id;

	private String userName;

}
