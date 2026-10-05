package household_recharge_backend.service;

import household_recharge_backend.model.MobileNumber;
import household_recharge_backend.model.Recharge;
import household_recharge_backend.repository.MobileNumberRepository;
import household_recharge_backend.repository.RechargeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RechargeService {

    private final RechargeRepository rechargeRepository;
    private final MobileNumberRepository mobileNumberRepository;

    public RechargeService(
            RechargeRepository rechargeRepository,
            MobileNumberRepository mobileNumberRepository
    ) {
        this.rechargeRepository = rechargeRepository;
        this.mobileNumberRepository = mobileNumberRepository;
    }

    public Recharge createRecharge(Recharge recharge) {

        // 1. Save the recharge first
        Recharge savedRecharge = rechargeRepository.save(recharge);

        // 2. Find the mobile number associated with this recharge
        List<MobileNumber> mobileNumbers =
                mobileNumberRepository.findByAccountId(
                        recharge.getAccountId()
                );

        // 3. Find the matching mobile number
        for (MobileNumber mobileNumber : mobileNumbers) {

            if (mobileNumber.getMobileNumber()
                    .equals(recharge.getMobileNumber())) {

                // 4. Update lastRechargeId
                mobileNumber.setLastRechargeId(
                        savedRecharge.getId()
                );

                // 5. Save the updated mobile number
                mobileNumberRepository.save(mobileNumber);

                break;
            }
        }

        return savedRecharge;
    }

    public List<Recharge> getAllRecharges() {
        return rechargeRepository.findAll();
    }

    public List<Recharge> getByHouseholdId(String householdId) {
        return rechargeRepository.findByHouseholdId(householdId);
    }

    public List<Recharge> getByAccountId(String accountId) {
        return rechargeRepository.findByAccountId(accountId);
    }

    public List<Recharge> getByMobileNumber(String mobileNumber) {
        return rechargeRepository.findByMobileNumber(mobileNumber);
    }

    public Recharge getById(String id) {
        return rechargeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Recharge not found")
                );
    }
}