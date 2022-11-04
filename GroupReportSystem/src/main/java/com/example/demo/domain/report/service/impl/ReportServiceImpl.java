package com.example.demo.domain.report.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.report.model.Report;
import com.example.demo.domain.report.service.ReportService;
import com.example.demo.repository.ReportMapper;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    ReportMapper reportMapper;

    /** 新規日報を登録 */
    @Override
    public void signupReport(Report report) {
        reportMapper.signupOne(report);
    }

    /** 日報一覧を取得 */
    @Override
    public List<Report> getReportList(){
        return reportMapper.findMany();
    }

    /** 日報詳細を表示 */
    @Override
    public Report getReportDetail(int reportId) {
        return reportMapper.findOne(reportId);
    }

    /** 日報を更新 */
    @Override
    public void updateReport(Report report) {
        reportMapper.updateOne(report);
    }

    /** 日報を削除 */
    @Override
    public void deleteReport(int ReportId) {
        reportMapper.deleteOne(ReportId);
    }

    /** 日報番号から日報を1件取得 */
    @Override
    public Report getReportDetailByCode(String reportCode) {
        return reportMapper.getReportOneByCode(reportCode);
    }

}
