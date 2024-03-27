package com.yoga.backend.model;
import com.yoga.backend.enumerated.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="CourseList_Available")
public class courselist {
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long pid;
	private String courseName;
	private String academyName;
	private String description;
	private String imgUrl;
	@Enumerated(EnumType.STRING)
	private Role role;
}






// @Data
// @Builder
// @NoArgsConstructor
// @AllArgsConstructor
// public class Campaign {
	
// //	@GeneratedValue(strategy = GenerationType.UUID)




// }