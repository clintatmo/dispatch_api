package sr.dispatch.api.service;

import org.passay.CharacterRule;
import org.springframework.stereotype.Service;

import java.util.List;

/* * * @author Clint Atmosoerodjo #commander *  */

@Service
public interface PasswordService {

    String generatePassword(List<CharacterRule> characterRuleList, Integer passwordLength);

    String encryptPassword(String password);

    String createPassword(String password, List<CharacterRule> characterRuleList, Integer passwordLength);

    Boolean matchPassword(String rawPassword, String encryptedPassword);
}