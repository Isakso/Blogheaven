package com.example.bloggheaven.services;

import com.example.bloggheaven.exceptions.ResourceNotFoundException;
import com.example.bloggheaven.models.Address;
import com.example.bloggheaven.models.Blog;
import com.example.bloggheaven.models.User;
import com.example.bloggheaven.repositories.AddressRepository;
import com.example.bloggheaven.repositories.BlogRepository;
import com.example.bloggheaven.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public List<User> getAllusers() {
        return userRepository.findAll();
    }
    @Override
    public User getUserById(int id) {

        if(userRepository.existsById(id)) {
            Optional<User> existingUser = userRepository.findById(id);
            if(existingUser.isPresent()){
                return existingUser.get();
            }
        }
        throw new ResourceNotFoundException("User","Id",id);
    }

    @Override
    @Transactional
    public User addUser(User user) {  // coupling address and blog to user before saving
        Address address = user.getAddress();

        if (address != null && address.getAddressId() != 0) {
            //Optional<Address> currentAddress = addressRepository.findById(address.getAddressId());
            Blog blog = blogRepository.save(user.getBlog());
            user.setBlog(blog);
        } else {
            addressRepository.save(address);
            user.setAddress(address);
        }
        return userRepository.save(user);

    }
    @Override
    public void deleteUserById(int id) {
     userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userRepository.deleteById(id);

    }
    @Override
    public User updateUser(int id, User user) {
        return null;
    }
}
