package Dao;

import java.util.ArrayList;
import java.util.List;

import Bean.Victim;
import Dto.VictimsDto;
import Exceptions.VictimExceptions;

public class VictimDaoImp implements VictimDao {
    
    private static List<Victim> victimList = new ArrayList<>();
    private static List<VictimsDto> victimsDtoList = new ArrayList<>();
    
    // Initialize with some sample data
    
    
    @Override
    public String registerVictim(Victim victim) throws VictimExceptions {
        for (Victim v : victimList) {
            if (v.getVictimId() == victim.getVictimId()) {
                throw new VictimExceptions("Victim with ID " + victim.getVictimId() + " already exists");
            }
        }
        
        victimList.add(victim);
        return "Victim registered successfully";
    }

    @Override
    public List<Victim> getAllVictims() throws VictimExceptions {
        if (victimList.isEmpty()) {
            throw new VictimExceptions("No victims found");
        }
        return victimList;
    }

    @Override
    public List<VictimsDto> getVictimsByCrimeType(String crimeType) throws VictimExceptions {
        List<VictimsDto> result = new ArrayList<>();
        for (VictimsDto dto : victimsDtoList) {
            if (dto.getCrimeType().equalsIgnoreCase(crimeType)) {
                result.add(dto);
            }
        }
        
        if (result.isEmpty()) {
            throw new VictimExceptions("No victims found for crime type " + crimeType);
        }
        
        return result;
    }

    @Override
    public String updateVictimDetails(Victim victim) throws VictimExceptions {
        boolean updated = false;
        for (int i = 0; i < victimList.size(); i++) {
            if (victimList.get(i).getVictimId() == victim.getVictimId()) {
                victimList.set(i, victim);
                updated = true;
                break;
            }
        }
        
        if (!updated) {
            throw new VictimExceptions("Victim with ID " + victim.getVictimId() + " does not exist");
        }
        
        return "Victim details updated successfully";
    }

    @Override
    public String deleteVictim(int victimId) throws VictimExceptions {
        boolean removed = false;
        for (int i = 0; i < victimList.size(); i++) {
            if (victimList.get(i).getVictimId() == victimId) {
                victimList.remove(i);
                removed = true;
                break;
            }
        }
        
        if (!removed) {
            throw new VictimExceptions("Victim with ID " + victimId + " does not exist");
        }
        
        return "Victim deleted successfully";
    }
    
    // Method to add victim DTO for testing
    public static void addVictimsDto(VictimsDto dto) {
        victimsDtoList.add(dto);
    }
}

