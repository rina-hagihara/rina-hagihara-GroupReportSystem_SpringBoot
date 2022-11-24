package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.report.model.Report;

@Mapper
public interface ReportMapper {

	/** 新規日報登録 */
	public void signupOne(Report report);

	/** 日報リスト表示 */
	public List<Report> findMany();

	/** 日報詳細を表示 */
	public Report findOne(int reportId);

	/** 日報情報を更新 */
	public void updateOne(Report report);

	/** 日報情報を削除 */
	public void deleteOne(int reportId);

	/** 日報番号から日報を1件取得 */
	public Report getReportOneByCode(String reportCode);

}
