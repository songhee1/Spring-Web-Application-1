# 실전! 스프링부트 JPA 활용 1 강의 정리 

<br>
<br>
<br>

## 엔티티 설계시 주의점

<br>

- 가급적 setter을 사용하지 않도록 해야한다. 유지보수가 어렵다.

<br>

- *** 모든 연관관계는 지연로딩으로 설정해야 한다 ***
 - 즉시로딩 EAGER : 예측이 힘들고 어떤 SQL이 실행될지 
 - 지연로딩 LAZY : 실무에서 모든 연관관계는 지연로딩으로 꼭 설정해야한다.
 @OneToMany은 FetchType.LAZY, @ManyToOne은 FetchType.EAGER로 되어 있다. 100개를 조회하는 상황이 생기게 되면, 좋은 코드가 안되게 된다. 따라서, @ManyToOne 은 모두 FetchType.LAZY로 작성하도록 한다. 모두 잡아주어야 한다. @OneToOne도 (fetch= FetchType.LAZY)로 똑같이 설정한다.
 => 따라서 @XToOne은 모두 직접 지연로딩으로 설정해야 한다.

<br>

## 테이블 생성전략

<br>

- 하이버네이트 기존 구현시 엔티티 필드명을 그대로 테이블명으로 사용된다.

- 스프링부트 신규 설정(엔티티(필드)->테이블(칼럼))
 - (1) 자바의 camalcase를 underscore로 바꾸어 테이블에 저장된다. 
 - (2) .점 -> _(언더스코어)
 - (3) 대문자 -> 소문자

<br>

- 논리명은 테이블명과 테이블명을 적지 않았을때 논리명을 적용하는 것이며, 물리명은 매핑으로 바꿀때 실제 테이블에 모두 적용하는 것이다. 

<br>
<br>

- @Repository : 스프링 빈에 등록된다. 컴포넌트 스캔의 대상이 된다. 
- @PersistenceContext : 엔티티 매니저를 주입받을 수 있다. 스프링이 모두 해결
 - @PersistenceUnit : 엔티티 팩토리로 매니저를 직접 주입할 수도 있다. 
- 스프링이 제공하는 트랜잭션을 쓰는 것이 좋다. 쓸수있는 옵션이 많기 때문에 권장.
 - @ Transactional

<br>
<br>

### 생성자 injection
```java
 private final MemberRepository memberRespository;

 @Autowired
 public MemberSerivce(MemberRepository memberRepository){
 this.memberRepository=memberRespository;
}
```
- 해당 @Autowired내용은 @RequiredArgsConstructor 한줄로 대체 할 수 있다. 


