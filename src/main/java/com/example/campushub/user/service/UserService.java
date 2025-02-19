package com.example.campushub.user.service;

import java.util.List;
import java.util.Optional;

import com.example.campushub.user.domain.Type;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.campushub.global.error.exception.UserNotFoundException;
import com.example.campushub.user.domain.User;
import com.example.campushub.user.dto.LoginUser;
import com.example.campushub.user.dto.UserFindAllDto;
import com.example.campushub.user.dto.UserFindOneDto;
import com.example.campushub.user.dto.UserSearchCondition;
import com.example.campushub.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

	private final UserRepository userRepository;

	//학생 전체, 컨디션 조회
	public List<UserFindAllDto> getStudentByCondition(LoginUser loginUser, UserSearchCondition condition) {
		userRepository.findByUserNumAndType(loginUser.getUserNum(), Type.ADMIN)
			.orElseThrow(UserNotFoundException::new);

		return userRepository.findAllStudentByCondition(condition);
	}

	//교수 전체, 컨디션 조회
	public List<UserFindAllDto> getProfessorByCondition(LoginUser loginUser, UserSearchCondition condition) {
		userRepository.findByUserNumAndType(loginUser.getUserNum(), Type.ADMIN)
			.orElseThrow(UserNotFoundException::new);

		return userRepository.findAllProfessorByCondition(condition);
	}

	//학생 단건 조회
	public UserFindOneDto getStudentByUserNum(LoginUser loginUser, String userNum) {
		userRepository.findByUserNumAndType(loginUser.getUserNum(), Type.ADMIN)
			.orElseThrow(UserNotFoundException::new);

		return userRepository.getStudentByUserNum(userNum)
			.orElseThrow(UserNotFoundException::new);
	}
	//교수 단건 조회
	public UserFindOneDto getProfessorByUserNum(LoginUser loginUser, String userNum) {
		userRepository.findByUserNumAndType(loginUser.getUserNum(), Type.ADMIN)
			.orElseThrow(UserNotFoundException::new);

		return userRepository.getProfessorByUserNum(userNum)
			.orElseThrow(UserNotFoundException::new);
	}

	//학색 상태 변경
	@Transactional
	public void updateUserStatus(LoginUser loginUser, List<String> userNums) {
		//관리자 확인
		userRepository.findByUserNumAndType(loginUser.getUserNum(), Type.ADMIN)
			.orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 없습니다."));

		List<User> users = userRepository.findAllByUserNums(userNums);

		for (User user : users) {
			if (!user.isSuccessStatus()){
				throw new IllegalArgumentException("ERROR");
			}
			user.updateStatus();
		}
	}

}
