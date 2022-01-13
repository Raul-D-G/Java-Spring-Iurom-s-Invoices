package IuromInvoices.services;


import IuromInvoices.dao.daoClient.ClientDataAccessService;
import IuromInvoices.exception.ClientNotFoundException;
import IuromInvoices.models.Client;
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

    @Test
    @DisplayName("Id valid")
    void getClientById() {
        //arrange
        UUID id = UUID.randomUUID();
        String nume = "Test";
        String cui = "ROtest";
        String adresa = "Adresa Test";
        String nrCont = "ROXXBRDE200SVTEST";
        Client client  = new Client(id, nume, cui, adresa, nrCont);

        Mockito.when(clientDao.selectClientById(Mockito.any()))
                .thenReturn(Optional.of(client));

        //act
        Client getClientByid = clientService.getClientById(id);

        //assert
        Assertions.assertNotNull(getClientByid);
        Assertions.assertEquals(nume, getClientByid.getNume());
        Assertions.assertEquals(cui, getClientByid.getCui());
        Assertions.assertEquals(adresa, getClientByid.getAdresa());
        Assertions.assertEquals(nrCont, getClientByid.getNrCont());
    }

    @Test
    @DisplayName("Id invalid")
    void updateClient() {
        //arrange
        UUID idInvalid = UUID.randomUUID();
        String nume = "Test";
        String cui = "ROtest";
        String adresa = "Adresa Test";
        String nrCont = "ROXXBRDE200SVTEST";
        Client client  = new Client(idInvalid, nume, cui, adresa, nrCont);

        Mockito.when(clientDao.updateClientById(Mockito.any(), Mockito.any()))
                .thenReturn(0);

        //act
        ClientNotFoundException exception = Assertions.assertThrows(ClientNotFoundException.class,
                () -> clientService.updateClient(idInvalid, client));

        //assert
        Assertions.assertEquals("Clientul nu a fost gasit!", exception.getMessage());
    }
}
