package Dao;

import java.util.ArrayList;
import java.util.List;

import Bean.Criminal;
import Dto.CrimesDoneByCriminalDto;
import Dto.CriminalArrestedDto;
import Exceptions.CriminalExceptions;

public class CriminalDaoImp implements CriminalDao {
    
    private static List<Criminal> criminalList = new ArrayList<>();
    private static List<CrimesDoneByCriminalDto> crimesDoneByCriminalDtoList = new ArrayList<>();
    private static List<CriminalArrestedDto> criminalArrestedDtoList = new ArrayList<>();
    
   
    
    @Override
    public String registerCriminal(Criminal criminal) throws CriminalExceptions {
        for (Criminal c : criminalList) {
            if (c.getCriminalId() == criminal.getCriminalId()) {
                throw new CriminalExceptions("Criminal with ID " + criminal.getCriminalId() + " already exists");
            }
        }
        
        criminalList.add(criminal);
        return "Criminal registered successfully";
    }

    @Override
    public List<Criminal> getAllCriminals() throws CriminalExceptions {
        if (criminalList.isEmpty()) {
            throw new CriminalExceptions("No criminals found");
        }
        return criminalList;
    }

    @Override
    public List<CrimesDoneByCriminalDto> getCrimesByCriminalId(int criminalId) throws CriminalExceptions {
        boolean criminalExists = false;
        for (Criminal c : criminalList) {
            if (c.getCriminalId() == criminalId) {
                criminalExists = true;
                break;
            }
        }
        
        if (!criminalExists) {
            throw new CriminalExceptions("Criminal with ID " + criminalId + " does not exist");
        }
        
        List<CrimesDoneByCriminalDto> result = new ArrayList<>();
        for (CrimesDoneByCriminalDto dto : crimesDoneByCriminalDtoList) {
            if (dto.getCriminalId() == criminalId) {
                result.add(dto);
            }
        }
        
        if (result.isEmpty()) {
            throw new CriminalExceptions("No crimes found for criminal ID " + criminalId);
        }
        
        return result;
    }

    @Override
    public List<CriminalArrestedDto> getCriminalsByPoliceStation(String policeStation) throws CriminalExceptions {
        List<CriminalArrestedDto> result = new ArrayList<>();
        for (CriminalArrestedDto dto : criminalArrestedDtoList) {
            if (dto.getPoliceStation().equalsIgnoreCase(policeStation)) {
                result.add(dto);
            }
        }
        
        if (result.isEmpty()) {
            throw new CriminalExceptions("No criminals found for Area " + policeStation);
        }
        
        return result;
    }

    @Override
    public String updateCriminalDetails(Criminal criminal) throws CriminalExceptions {
        boolean updated = false;
        for (int i = 0; i < criminalList.size(); i++) {
            if (criminalList.get(i).getCriminalId() == criminal.getCriminalId()) {
                criminalList.set(i, criminal);
                updated = true;
                break;
            }
        }
        
        if (!updated) {
            throw new CriminalExceptions("Criminal with ID " + criminal.getCriminalId() + " does not exist");
        }
        
        return "Criminal details updated successfully";
    }

    @Override
    public String deleteCriminal(int criminalId) throws CriminalExceptions {
        boolean removed = false;
        for (int i = 0; i < criminalList.size(); i++) {
            if (criminalList.get(i).getCriminalId() == criminalId) {
                criminalList.remove(i);
                removed = true;
                break;
            }
        }
        
        if (!removed) {
            throw new CriminalExceptions("Criminal with ID " + criminalId + " does not exist");
        }
        
        return "Criminal deleted successfully";
    }
    
    // Methods to add DTOs for testing
    public static void addCrimesDoneByCriminalDto(CrimesDoneByCriminalDto dto) {
        crimesDoneByCriminalDtoList.add(dto);
    }
    
    public static void addCriminalArrestedDto(CriminalArrestedDto dto) {
        criminalArrestedDtoList.add(dto);
    }
}

