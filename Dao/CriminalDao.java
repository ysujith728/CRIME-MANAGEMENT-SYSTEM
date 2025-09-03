package Dao;

import java.util.List;

import Bean.Criminal;
import Dto.CrimesDoneByCriminalDto;
import Dto.CriminalArrestedDto;
import Exceptions.CriminalExceptions;

public interface CriminalDao {
    public String registerCriminal(Criminal criminal) throws CriminalExceptions;
    public List<Criminal> getAllCriminals() throws CriminalExceptions;
    public List<CrimesDoneByCriminalDto> getCrimesByCriminalId(int criminalId) throws CriminalExceptions;
    public List<CriminalArrestedDto> getCriminalsByPoliceStation(String policeStation) throws CriminalExceptions;
    public String updateCriminalDetails(Criminal criminal) throws CriminalExceptions;
    public String deleteCriminal(int criminalId) throws CriminalExceptions;
}

