package org.impelsys.SpringBootDemo.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.impelsys.SpringBootDemo.dao.UserDao;
import org.impelsys.SpringBootDemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Path("/users")
@XmlRootElement(name="User")
public class UserResource {
	
//	@Autowired
//	SessionFactory sessionFactory;
	@Qualifier("userDao")
	@Autowired
	UserDao userDao;
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getUserById(@PathParam("id") int id) {
	
//		User user1 = new User();
//		user1.setUserEmail("kks@gmail.com");
//		user1.setUserName("Abc");
//		user1.setId(id);
		User user1 = userDao.viewUser(id);
		Response.ResponseBuilder builder = Response.status(Status.OK);
		Response response = builder.entity(user1).build();
//		return Response.status(200).entity(user1).build();
		return response;
		
	}
	
	@GET
	@Path("/list")
	@Produces("application/json")
	public Response getUser() {
		List<User> userList = userDao.listUsers();
		Response.ResponseBuilder builder = Response.status(Status.OK);
		Response response = builder.entity(userList).build();
		return response;
	}
	
	@DELETE
	@Path("/remove/{id}")
	@Produces("application/json")
	public Response delete(@PathParam("id") int id) {
		userDao.deleteUser(id);
		Response.ResponseBuilder builder = Response.status(Status.OK);
		Response response = builder.entity(id).build();
		return response;
	}
	
	
//http://localhost:8080/Messenger/users/1
	@POST
	@Path("/user")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUser(User user) {
		int id = userDao.addUser(user);
		Response.ResponseBuilder builder = Response.status(Status.OK);
		Response response = builder.entity("Created user"+ id).build();
		return response;
	}
	
}
