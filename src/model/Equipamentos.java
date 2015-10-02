/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Luiz Carlos
 */
public class Equipamentos {
    
    private int idEquipamentos;
    private String descricao;
    private String vslorPago;
    private String localAtual;
    private String numeroSerial;
    private String garantia;

    public int getIdEquipamentos() {
        return idEquipamentos;
    }

    public void setIdEquipamentos(int idEquipamentos) {
        this.idEquipamentos = idEquipamentos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getVslorPago() {
        return vslorPago;
    }

    public void setVslorPago(String vslorPago) {
        this.vslorPago = vslorPago;
    }

    public String getLocalAtual() {
        return localAtual;
    }

    public void setLocalAtual(String localAtual) {
        this.localAtual = localAtual;
    }

    public String getNumeroSerial() {
        return numeroSerial;
    }

    public void setNumeroSerial(String numeroSerial) {
        this.numeroSerial = numeroSerial;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }
    
    
}
