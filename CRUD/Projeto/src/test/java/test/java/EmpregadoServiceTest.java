package test.java;

import com.projeto.crud.dto.EmpregadoDTO;
import com.projeto.crud.exception.ResourceNotFoundException;
import com.projeto.crud.model.Cargo;
import com.projeto.crud.model.Empregado;
import com.projeto.crud.repository.EmpregadoRepository;
import com.projeto.crud.service.CargoService;
import com.projeto.crud.service.EmpregadoService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmpregadoServiceTest {

    @InjectMocks
    private EmpregadoService empregadoService;

    @Mock
    private EmpregadoRepository empregadoRepository;

    @Mock
    private CargoService cargoService;

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveCriarEmpregadoComSucesso() {
        // Arrange
        Cargo cargo = new Cargo(1L, "Desenvolvedor", "Desenvolve coisas");
        EmpregadoDTO dto = EmpregadoDTO.builder()
                .nome("João Silva")
                .email("joao@email.com")
                .dataAdmissao(LocalDate.now())
                .cargoId(1L)
                .build();

        Empregado empregadoSalvo = Empregado.builder()
                .id(1L)
                .nome(dto.getNome())
                .email(dto.getEmail())
                .dataAdmissao(dto.getDataAdmissao())
                .cargo(cargo)
                .build();

        when(cargoService.buscarEntidadePorId(1L)).thenReturn(cargo);
        when(empregadoRepository.save(any(Empregado.class))).thenReturn(empregadoSalvo);

        // Act
        EmpregadoDTO resultado = empregadoService.criar(dto);

        // Assert
        assertNotNull(resultado);
        assertEquals("João Silva", resultado.getNome());
        assertEquals("joao@email.com", resultado.getEmail());
        verify(empregadoRepository, times(1)).save(any(Empregado.class));
    }

    @Test
    void deveLancarExcecao_QuandoEmpregadoNaoEncontrado() {
        // Arrange
        Long idNaoExistente = 99L;
        when(empregadoRepository.findById(idNaoExistente)).thenReturn(Optional.empty());

        // Act & Assert
        ResourceNotFoundException ex = assertThrows(ResourceNotFoundException.class, () -> {
            empregadoService.buscarPorId(idNaoExistente);
        });

        assertEquals("Empregado com ID 99 não encontrado", ex.getMessage());
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }
}
