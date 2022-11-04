package com.example.demo.ap.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.ap.form.ReportSignupForm;
import com.example.demo.ap.form.ReportUpdateForm;
import com.example.demo.domain.mission.service.MissionService;
import com.example.demo.domain.report.model.Report;
import com.example.demo.domain.report.service.ReportService;

import lombok.extern.slf4j.Slf4j;



@Controller
@RequestMapping("/report")
@Slf4j
public class ReportController {


    @Autowired
    ReportService reportService;

    @Autowired
    MissionService missionService;

    @Autowired
    ModelMapper modelMapper;



    /** 新規日報作成画面表示 */
    @GetMapping("/signup/{missionId}")
    String getSignupReport(@PathVariable("missionId")int missionId, @ModelAttribute ReportSignupForm form,
            Model model) {
        model.addAttribute("missionId", missionId);
        return "report/signup";
    }

    /** 新規日報作成処理 */
    @PostMapping("/signup/{missionId}")
    String postReportSignup(@PathVariable("missionId")int missionId, @ModelAttribute @Validated ReportSignupForm form,
            BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            getSignupReport(missionId, form, model);
        }

        log.info(form.toString());

        Report report = modelMapper.map(form, Report.class);
        reportService.signupReport(report);

        Report savedReport = reportService.getReportDetailByCode(report.getReportCode());
        int reportId =  savedReport.getReportId();
        missionService.connectMissionToReport(missionId, reportId);

        return "redirect:/mission/detail/{missionId}";


    }

    /** 日報一覧表示
    @GetMapping("/list")
    public String getReportList(Model model) {

        List<Report> reportList = reportService.getReportList();
        model.addAttribute("reportList", reportList);

        return "report/list";
    } */


    /** 日報詳細表示 */
    @GetMapping("detail/{reportId}/{missionId}")
    public String getReportDetail(@PathVariable("reportId")int reportId,
            @PathVariable("missionId")int missionId, Model model) {

        Report report = reportService.getReportDetail(reportId);
        model.addAttribute("report", report);

        model.addAttribute("missionId", missionId);

        return "report/detail";
    }

    /** 日報更新画面表示 */
    @GetMapping("/update/{reportId}/{missionId}")
    public String getUpdateReport(@PathVariable("reportId")int reportId, @PathVariable("missionId")int missionId,
            Model model, @ModelAttribute ReportUpdateForm reportUpdateForm) {

        if(reportUpdateForm.getReportTitle() == null) {
        /** 既に登録済みの情報を画面に表示 */
        Report savedReport = reportService.getReportDetail(reportId);
        reportUpdateForm = modelMapper.map(savedReport, ReportUpdateForm.class);
        model.addAttribute("reportUpdateForm", reportUpdateForm);
        }

        model.addAttribute("reportId", reportId);

        log.info("reportUpdateForm.toString() :" + reportUpdateForm.toString());

        return "report/update";
    }

    /** 日報更新処理 */
    @PostMapping("/update/{reportId}/{missionId}")
    public String updateReport(@PathVariable("reportId")int reportId, @PathVariable("missionId")int missionId,
            @ModelAttribute @Validated ReportUpdateForm reportUpdateForm
            ,BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            getUpdateReport(reportId, missionId, model, reportUpdateForm);
        }

        log.info("reportUpdateForm.toString() :" + reportUpdateForm.toString());

        /** 更新処理 */
        Report report = modelMapper.map(reportUpdateForm, Report.class);
        reportService.updateReport(report);

        return "redirect:/mission/detail/{missionId}";


    }

    /** 日報削除処理 */
    @PostMapping("/delete/{reportId}/{missionId}")
    public String deleteReportOne(@PathVariable("reportId")int reportId, @PathVariable("missionId")int missionId) {

        reportService.deleteReport(reportId);

        return "redirect:/mission/detail/{missionId}";
    }













}
