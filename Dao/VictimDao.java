package Dao;

import java.util.List;

import Bean.Victim;
import Dto.VictimsDto;
import Exceptions.VictimExceptions;

public interface VictimDao {
    public String registerVictim(Victim victim) throws VictimExceptions;
    public List<Victim> getAllVictims() throws VictimExceptions;
    public List<VictimsDto> getVictimsByCrimeType(String crimeType) throws VictimExceptions;
    public String updateVictimDetails(Victim victim) throws VictimExceptions;
    public String deleteVictim(int victimId) throws VictimExceptions;
}

