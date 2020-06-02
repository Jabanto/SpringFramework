package com.jabanto.spring.SpringMVc.Service;

import com.jabanto.spring.SpringMVc.Model.Privilege;
import com.jabanto.spring.SpringMVc.Model.Role;
import com.jabanto.spring.SpringMVc.Model.UserModel;
import com.jabanto.spring.SpringMVc.Repository.RoleUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.PrivilegedAction;
import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


/**
 * We create our specifically UserDetails Service implementing UserDetailService Interface
 * , and override the loadUserByUserName method and acces to the information of the user in the mysql data base
 * using JDBC template to charge/mapping the required on the User model class
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    RoleUserRepo roleUserRepo;

    Privilege readPrivilege = new Privilege("READ_PRIVILEGE");
    Privilege writePrivilege = new Privilege("WRITE_PRIVILEGE");
    Privilege updatePrivilege = new Privilege("UPDATE_PRIVILEGE");
    Privilege deletePrivilege = new Privilege("DELETE_PRIVILEGE");

    List<Privilege> adminPrivileges = Arrays.asList(readPrivilege,writePrivilege,updatePrivilege,deletePrivilege);
    List<Privilege> userPrivileges = Arrays.asList(readPrivilege,updatePrivilege);

    /**
     * Load the user Information base on the data saved on the mysql DB
     * @param userName
     * @return The information of the User charge on a User that implements UserDetails Interface
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserModel userRetval = roleUserRepo.getUserByName(userName);
        Role roleUserRetval = roleUserRepo.getRoleByUserId(userRetval.getId());
        ArrayList<GrantedAuthority> list = new ArrayList<>();

        return new User(userRetval.getLogin(),userRetval.getPassword(),
                    true,true,true,true,
                    getAuthorities(Arrays.asList(roleUserRetval)));

        //return new User(userRetval.getLogin(),userRetval.getPassword(),list);
    }


    private Collection<? extends GrantedAuthority> getAuthorities(
            Collection<Role> roles ){
        return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges){
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges){
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

    private List<String> getPrivileges(Collection<Role> roles){

        List<String> privileges = new ArrayList<>();
        List<Privilege> collection = new ArrayList<>();

        for(Role role: roles){
            if (role.getRoleAdmin()==1){
                collection.addAll(adminPrivileges);
            }else{
                collection.addAll(userPrivileges);
            }
        }

        for (Privilege item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }


}
