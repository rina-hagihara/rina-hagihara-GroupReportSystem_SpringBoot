package com.example.demo.domain.report.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.report.model.Report;

@Service
public interface ReportService {

    /** 新規日報を登録 */
    public void signupReport(Report report);

    /** 日報一覧を取得 */
    public List<Report> getReportList();

    /** 日報詳細を表示 */
    public Report getReportDetail(int reportId);

    /** 日報を更新 */
    public void updateReport(Report report);

    /** 日報を削除 */
    public void deleteReport(int ReportId);

    /** 日報番号から日報を1件取得 */
    public Report getReportDetailByCode(String reportCode);
}
