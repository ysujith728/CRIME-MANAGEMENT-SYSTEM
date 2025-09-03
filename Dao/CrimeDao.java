package Dao;

import java.util.List;

import Bean.Crime;
import Dto.CriminalsCrimeDto;
import Exceptions.CrimeExceptions;

public interface CrimeDao {
    public String registerCrime(Crime crime) throws CrimeExceptions;
    public List<Crime> getAllCrimes() throws CrimeExceptions;
    public List<CriminalsCrimeDto> getCriminalsByCrimeId(int crimeId) throws CrimeExceptions;
    public String updateCrimeDetails(Crime crime) throws CrimeExceptions;
    public String deleteCrime(int crimeId) throws CrimeExceptions;
}

