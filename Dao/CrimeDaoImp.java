package Dao;

import java.util.ArrayList;
import java.util.List;

import Bean.Crime;
import Dto.CriminalsCrimeDto;
import Exceptions.CrimeExceptions;

public class CrimeDaoImp implements CrimeDao {
    
    private static List<Crime> crimeList = new ArrayList<>();
    private static List<CriminalsCrimeDto> criminalsCrimeDtoList = new ArrayList<>();
    
    
    
    @Override
    public String registerCrime(Crime crime) throws CrimeExceptions {
        for (Crime c : crimeList) {
            if (c.getCrimeId() == crime.getCrimeId()) {
                throw new CrimeExceptions("Crime with ID " + crime.getCrimeId() + " already exists");
            }
        }
        
        crimeList.add(crime);
        return "Crime registered successfully";
    }

    @Override
    public List<Crime> getAllCrimes() throws CrimeExceptions {
        if (crimeList.isEmpty()) {
            throw new CrimeExceptions("No crimes found");
        }
        return crimeList;
    }

    @Override
    public List<CriminalsCrimeDto> getCriminalsByCrimeId(int crimeId) throws CrimeExceptions {
        boolean crimeExists = false;
        for (Crime c : crimeList) {
            if (c.getCrimeId() == crimeId) {
                crimeExists = true;
                break;
            }
        }
        
        if (!crimeExists) {
            throw new CrimeExceptions("Crime with ID " + crimeId + " does not exist");
        }
        
        List<CriminalsCrimeDto> result = new ArrayList<>();
        for (CriminalsCrimeDto dto : criminalsCrimeDtoList) {
            if (dto.getCrimeId() == crimeId) {
                result.add(dto);
            }
        }
        
        if (result.isEmpty()) {
            throw new CrimeExceptions("No criminals found for crime ID " + crimeId);
        }
        
        return result;
    }

    @Override
    public String updateCrimeDetails(Crime crime) throws CrimeExceptions {
        boolean updated = false;
        for (int i = 0; i < crimeList.size(); i++) {
            if (crimeList.get(i).getCrimeId() == crime.getCrimeId()) {
                crimeList.set(i, crime);
                updated = true;
                break;
            }
        }
        
        if (!updated) {
            throw new CrimeExceptions("Crime with ID " + crime.getCrimeId() + " does not exist");
        }
        
        return "Crime details updated successfully";
    }

    @Override
    public String deleteCrime(int crimeId) throws CrimeExceptions {
        boolean removed = false;
        for (int i = 0; i < crimeList.size(); i++) {
            if (crimeList.get(i).getCrimeId() == crimeId) {
                crimeList.remove(i);
                removed = true;
                break;
            }
        }
        
        if (!removed) {
            throw new CrimeExceptions("Crime with ID " + crimeId + " does not exist");
        }
        
        return "Crime deleted successfully";
    }
    
    // Method to add criminal crime DTO for testing
    public static void addCriminalCrimeDto(CriminalsCrimeDto dto) {
        criminalsCrimeDtoList.add(dto);
    }
}

