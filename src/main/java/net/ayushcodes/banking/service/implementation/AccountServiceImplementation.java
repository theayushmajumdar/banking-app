package net.ayushcodes.banking.service.implementation;

import net.ayushcodes.banking.dto.AccountDto;
import net.ayushcodes.banking.entity.Account;
import net.ayushcodes.banking.mapper.AccountMapper;
import net.ayushcodes.banking.repository.AccountRepository;
import net.ayushcodes.banking.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImplementation implements AccountService {
    private AccountRepository accountRepository;
    public AccountServiceImplementation(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override     //Create
public AccountDto createAccount(AccountDto accountDto) {
    Account account = AccountMapper.mapToAccount(accountDto);
    Account savedAccount = accountRepository.save(account);
    return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override     //Read ... Get
public AccountDto getAccountById(Long id) {
    Account account = accountRepository
            .findById(id)
            .orElseThrow(()-> new RuntimeException("Cannot find the given Account"));
    return AccountMapper.mapToAccountDto(account);
    }

    @Override   //Update ... deposit
public AccountDto deposit(Long id, double amount) {
    Account account = accountRepository
            .findById(id)
            .orElseThrow(()-> new RuntimeException("Cannot find the given Account")); // if doesnt exists in the database then throw exception

    double totalAmount = account.getBalance() + amount;
    account.setBalance(totalAmount);
    Account savedAccount = accountRepository.save(account);
    return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override    //Update ...Withdraw
public AccountDto withdraw(Long id, double amount) {
    Account account = accountRepository
            .findById(id)
            .orElseThrow(()-> new RuntimeException("Cannot find the given Account"));

    if (account.getBalance() < amount){
        throw new RuntimeException("Insufficient balance , Can't Withdraw the amount requested");
    }
    double total = account.getBalance()-amount;
    account.setBalance(total);
    Account savedAccount = accountRepository.save(account);
    return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override   //Get all the acc. present in the server
public List<AccountDto> getAllAccounts() {
    List<Account> accounts = accountRepository.findAll();
    return accounts.stream().map(account -> AccountMapper.mapToAccountDto(account))
            .collect(Collectors.toList());
    }

    @Override    //Delete REST API ...Deleting the account
public void deleteAccount(Long id) {
    Account account = accountRepository
            .findById(id)
            .orElseThrow(()-> new RuntimeException("Cannot find the given Account"));
    accountRepository.deleteById(id);
    }


}
