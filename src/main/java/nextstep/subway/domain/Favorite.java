package nextstep.subway.domain;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import nextstep.member.domain.Member;

@Entity
public class Favorite {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "source_id")
  private Station source;

  @ManyToOne
  @JoinColumn(name = "target_id")
  private Station target;

  @ManyToOne
  @JoinColumn(name = "member_id")
  private Member member;


  public Favorite() {

  }

  public Favorite(Member member, Station source, Station target) {
    this.source = source;
    this.target = target;
    this.member = member;
  }

  public static Favorite of(Member member, Station source, Station target) {
    isNotSame(source, target);
    return new Favorite(member, source, target);
  }

  public static void isNotSame(Station source, Station target) {
    if (source.equals(target)){
      throw new IllegalArgumentException("출발역과 도착역이 같습니다. 다른 역을 선택해주세요!");
    }
  }

  public Member getMember() {
    return member;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Favorite favorite = (Favorite) o;
    return Objects.equals(id, favorite.id) && Objects.equals(source,
        favorite.source) && Objects.equals(target, favorite.target);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, source, target);
  }

  public Station getTarget() {
    return target;
  }

  public Station getSource() {
    return source;
  }

}
