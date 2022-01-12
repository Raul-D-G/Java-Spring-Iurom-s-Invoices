package IuromInvoices.services;


import IuromInvoices.dao.daoClient.ClientDataAccessService;
import IuromInvoices.exception.ClientNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @Mock
    private ClientDataAccessService clientDao;

    @InjectMocks
    private ClientService clientService;

    @Test
    @DisplayName("Id invalid")
    void getClientByIdInvalid() {
        //arrange
        UUID invalidId = UUID.randomUUID();

        Mockito.when(clientDao.selectClientById(Mockito.any()))
                .thenReturn(Optional.empty());

        //act
        ClientNotFoundException exception = Assertions.assertThrows(ClientNotFoundException.class,
        () -> clientService.getClientById(invalidId));

        //assert
        Assertions.assertEquals("Clientul nu a fost gasit!", exception.getMessage());
    }


}
