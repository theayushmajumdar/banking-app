package net.ayushcodes.banking.repository;

import net.ayushcodes.banking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account , Long> {

}
