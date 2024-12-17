package tony.project.steam.domain.order.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;
import tony.project.steam.domain.order.entity.Payment;

@Mapper
public interface PaymentMapper {

    void savePayment(Payment payment);

    void updateTid(@Param("payment_id") Long paymentId, @Param("tid") String tid);

    String findTidById(@Param("pid") Long paymentId);

    Long findUserCodeById(@Param("pid") Long paymentId);

    void updatePaymentStatus(@Param("pid") Long paymentId,@Param("tid") String tid);

    Payment findPayment(@Param("pid") Long paymentId);

    void updateTidAndPrice(String tid, int total);
}