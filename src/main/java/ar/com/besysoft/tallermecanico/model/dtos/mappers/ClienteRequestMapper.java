package ar.com.besysoft.tallermecanico.model.dtos.mappers;

import ar.com.besysoft.tallermecanico.model.dtos.ClienteRequestDTO;
import ar.com.besysoft.tallermecanico.model.entities.Cliente;
import ar.com.besysoft.tallermecanico.model.entities.Vehiculo;

public class ClienteRequestMapper {

    public static Cliente mapToCliente(ClienteRequestDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setApellido(dto.getApellido());
        cliente.setCorreoElectronico(dto.getCorreoElectronico());
        cliente.setNombres(dto.getNombres());
        return cliente;
    }

    public static Vehiculo mapToVehiculo(ClienteRequestDTO dto) {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setPatente(dto.getPatente());
        return vehiculo;
    }
}
