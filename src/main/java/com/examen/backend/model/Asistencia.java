package com.examen.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fecha;
    private String horaEntrada;
    private String horaSalida;
    private String observacion;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;
}