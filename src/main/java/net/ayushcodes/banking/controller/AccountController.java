package net.ayushcodes.banking.controller;


import jakarta.servlet.http.PushBuilder;
import net.ayushcodes.banking.dto.AccountDto;
import net.ayushcodes.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.SqlReturnType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController            //  it will make it a spring rest controller class
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //Add Account REST API
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){ //auto conversion of json to java obj.
        return new ResponseEntity<>(accountService.createAccount(accountDto) , HttpStatus.CREATED);
    }

    //Get Account REST API
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto =accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    //Deposit ... Update Account REST API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id ,@RequestBody Map<String , Double> request){
        Double amount = request.get("amount"); //storing the input
        AccountDto accountDto = accountService.deposit(id , amount);
        return ResponseEntity.ok(accountDto);
    }

    //Withdraw ...Update Account REST API
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,@RequestBody Map<String,Double> request){
        Double amount = request.get("amount");
        AccountDto accountDto = accountService.withdraw(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    //Get all Accounts REST API
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    //Delete REST API ...Deleting the account
    @DeleteMapping("/{id}") //ann. for mapping the function
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){ //pathvariable ann for mapping the id
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account is deleted Successfully.");
    }

}
