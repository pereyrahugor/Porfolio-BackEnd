
package com.argprog.portfoliohrp.Repository;

import com.argprog.portfoliohrp.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @contact pereyrahugor@gmail.com
 * @author pereyra.hugo.r
 */

@Repository
public interface IPersonaRes extends JpaRepository <Persona, Long> {
    public Optional<Persona> findByContact (String contact);
    
    public boolean existsByContact(String contact);
}
