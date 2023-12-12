package scode.springscode.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scode.springscode.member.entity.Member;

public interface JpaMemberRepository extends JpaRepository<Member , Long> {
}
