package household_recharge_backend.service;

import household_recharge_backend.model.MobileNumber;
import household_recharge_backend.repository.MobileNumberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MobileNumberService {

    private final MobileNumberRepository mobileNumberRepository;

    public MobileNumberService(
            MobileNumberRepository mobileNumberRepository
    ) {
        this.mobileNumberRepository = mobileNumberRepository;
    }

    public MobileNumber addMobileNumber(
            MobileNumber mobileNumber
    ) {

        return mobileNumberRepository.save(mobileNumber);
    }

    public List<MobileNumber> getAllMobileNumbers() {

        return mobileNumberRepository.findAll();
    }

    public List<MobileNumber> getByHouseholdId(
            String householdId
    ) {

        return mobileNumberRepository
                .findByHouseholdId(householdId);
    }

    public List<MobileNumber> getByAccountId(
            String accountId
    ) {

        return mobileNumberRepository
                .findByAccountId(accountId);
    }

    public MobileNumber getById(String id) {

        return mobileNumberRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Mobile number not found"
                        ));
    }

    public void delete(String id) {

        if (!mobileNumberRepository.existsById(id)) {
            throw new RuntimeException(
                    "Mobile number not found"
            );
        }

        mobileNumberRepository.deleteById(id);
    }
}