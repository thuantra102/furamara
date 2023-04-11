package com.example.furama.repository.contract;

import com.example.furama.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IContractRepository extends JpaRepository<Contract,Long> {
    @Query(value = "select h.ma_hop_dong, k.ho_va_ten,h.ngay_lam_hop_dong, h.ngay_ket_thuc, h.tien_dat_coc,dv.ten_dich_vu  from hop_dong h\n" +
            "join khach_hang k on k.ma_khach_hang = h.ma_khach_hang\n" +
            "join dich_vu dv on h.ma_dich_vu = dv.ma_dich_vu", nativeQuery = true)
    Page<Contract> getAllContract(Pageable pageable);
}
