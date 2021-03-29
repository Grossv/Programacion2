/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.dao.implementation;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pojo.Vehicle;

/**
 *
 * @author Usuario
 */
public class VehicleTableModel extends AbstractTableModel{
    private List<String> columNames;
    private List<Vehicle> data;

    public VehicleTableModel() {
        super();
        columNames = new ArrayList<>();
        data = new ArrayList<>();
    }
    
    public VehicleTableModel(List<String> ColumNames, List<Vehicle> data){
        this.columNames = ColumNames;
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columNames.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        if (data.isEmpty()) {
            return null;
        }
        
        if (row < 0 || row >= data.size()) {
            return null;
        }
        
        List<String> vehicle = data.get(row).toList();
        
        if (col < 0 || col >= vehicle.size()) {
            return null;
        }
        
        return vehicle.get(col);
    }
    
    public int addRow() {
        return addRow(new Vehicle());
    }
    
    public int addRow(Vehicle row){
        data.add(row);
        fireTableRowsInserted(data.size() -1, data.size() -1);
        return data.size();
    }
    
    public void deleteRow(int row){
        if (row < 0) {
            return;
        }
        
        data.remove(row);
        fireTableRowsDeleted(row, row);
    }
    
    public void loadFromJson() throws FileNotFoundException {
        Gson gson = new Gson();
        data.addAll(Arrays.asList(gson.fromJson(new FileReader("/json/vehicleData.json"), Vehicle[].class)));
    }
    
    public void updateData(){
        try (Writer jsonWriter = new FileWriter("/json/vehicleData.json")){
            Gson gson = new Gson();
            JsonArray result = (JsonArray) gson.toJsonTree(data,new TypeToken<List<Vehicle>>() {}.getType());
            gson.toJson(result, jsonWriter);
        } catch (Exception e) {
        }
    }
}
