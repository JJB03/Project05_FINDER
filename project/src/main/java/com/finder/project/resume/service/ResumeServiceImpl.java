package com.finder.project.resume.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.finder.project.resume.dto.Option;
import com.finder.project.resume.dto.ResumeDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ResumeServiceImpl implements ResumeService {@Override
    public List<ResumeDto> list(Option option) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'list'");
    }

    @Override
    public ResumeDto select(int cv_no) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'select'");
    }

    @Override
    public int create(ResumeDto resumeDto) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public int update(ResumeDto resumeDto) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(int cv_no) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int count(Option option) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

  

}
