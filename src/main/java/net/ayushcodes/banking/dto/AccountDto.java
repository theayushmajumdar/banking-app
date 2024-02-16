package net.ayushcodes.banking.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
//to take inps for client and server
public class AccountDto {

    private Long id;
    private String accountHolderName;
    private double balance;
}
