package pages.Legal;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddCondemnationRecordPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AddCondemnationRecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	
	  By btnAddNew = By.xpath("//img[@id='ctl00_ConPHRightTop_TRLG_UC_radPanels_i2_i0_radGridLegal_radYALGridControl_ctl00_ctl02_ctl00_Img4']");
	     //Condemnation Info
	      By txtCondemnationName = By.xpath("//input[contains(@id,'_EditFormControl_PROC_NAME') and @type='text']");
	      By txtAssignedTo = By.xpath("//input[contains(@id,'_EditFormControl_ASSIGNED_TO') and @type='text']");
	      By txtAssignedDate = By.xpath("//input[contains(@id,'_DATE_ASSIGNED_dateInput') and @type='text']");
	      By txtInternalNotificationDate = By.xpath("//input[contains(@id,'_INTERNAL_NOTIFY_SENT_DATE_dateInput') and @type='text']");
	      By CondemnationCheckBox = By.xpath("//input[contains(@id,'_CONDEM_BY_PUBLICATION') and @type='checkbox']");
	      By txtComment = By.xpath("//textarea[contains(@id,'_radGridLegal_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_COMMENTS')]");
	      By txtNonSuitDate = By.xpath("//input[contains(@id,'_NON_Suit_Date_dateInput') and @type='text']");
	      By txtOriginalPetitionDate = By.xpath("//input[contains(@id,'_Petition_Filed_dateInput') and @type='text']");
	      By txtCause = By.xpath("//input[contains(@id,'_Original_Cause_No') and @type='text']");
	     //Corporate Resolution
	      By txtRequestedDate = By.xpath("//input[contains(@id,'_CORP_RES_REQ_DATE_dateInput') and @type='text']");
	      By txtReceivedDate = By.xpath("//input[contains(@id,'_CORP_RES_REC_DATE_dateInput') and @type='text']");
	     //Initial Offer
	      By txtSentDate = By.xpath("//input[contains(@id,'_FORMAL_WRITTEN_OFFER_DATE_dateInput') and @type='text']");
	      By txtAmount = By.xpath("//input[contains(@id,'FORMAL_WRITTEN_OFF_AMT') and @type='text']");
	      By SelectResponse = By.xpath("//input[contains(@id,'_FORMAL_WRITTEN_OFF_RESPONSE_ID_radYALDropDownList_Input') and @type='text']");
	     //Letter of Intent
	      By txtSentDateForLetter = By.xpath("//input[contains(@id,'_LOI_SENT_dateInput') and @type='text']");
	      By SelectResponseForLetter = By.xpath("//input[contains(@id,'_LOI_RESPONSE_radYALDropDownList_Input') and @type='text']");
	     //TRO Information
	      By txtCauseForTRO = By.xpath("//input[contains(@id,'_EditFormControl_TROCauseNo') and @type='text']");
	      By txtTempInjunctionHearingDate = By.xpath("//input[contains(@id,'_TRO_TempInjunction_Hearing_Date_dateInput') and @type='text']");
	      By txtTROHearingDate = By.xpath("//input[contains(@id,'_TROHearing_Date_dateInput') and @type='text']");
	      By txtT1HearingDate = By.xpath("//input[contains(@id,'_TRO_T1_Hearing_Date_dateInput') and @type='text']");
	     //Final Written Offer
	      By txtSentDateForFinal = By.xpath("(//input[contains(@name,'_WRITTEN_OFFER_DATE$dateInput') and @type='text'])[2]");
	      By txtAmountForFinal = By.xpath("//input[contains(@id,'_EditFormControl_FINAL_WRITTEN_OFFER_AMT') and @type='text']");
	      By SelectResponseForFinal = By.xpath("//input[contains(@id,'_FINAL_WRITTEN_OFFER_RESPONSE_ID_radYALDropDownList_Input') and @type='text']");
	      By LOBORIncludedCheckbox = By.xpath("//input[contains(@id,'_FINAL_WRITTEN_OFFER_LOBOR_INCLUDED') and @type='checkbox']");
	     //Condemnation Title
	      By RequestedDateCondemnationTitle = By.xpath("//input[contains(@id,'_TITLE_REQ_DATE_dateInput') and @type='text']");
	      By ReceivedDateCondemnationTitle = By.xpath("//input[contains(@id,'_TITLE_REC_DATE_dateInput') and @type='text']");
	    //Condemnation Appraisal
	      By RequestedDateCondemnationAppraisal = By.xpath("//input[contains(@id,'_APPRAISAL_REQ_DATE_dateInput') and @type='text']");
	      By ReceivedDateCondemnationAppraisal = By.xpath("//input[contains(@id,'_APPRAISAL_REC_DATE_dateInput') and @type='text']");
	      By txtProducedDate = By.xpath("//input[contains(@id,'_APPRAISAL_PRODUCED_DATE_dateInput') and @type='text']");
	      By txtAppraisalCompany =By.xpath("//input[contains(@id,'_APPRAISAL_COMPANY_ID_radYALDropDownList_Input') and @type='text']");
	      By txtAppraisalValue = By.xpath("//input[contains(@id,'_EditFormControl_APPRAISAL_VALUE') and @type='text']");
	      By AppraisalRequestedCancelledDate = By.xpath("//input[contains(@id,'_APPRAISAL_CANCELLED_dateInput') and @type='text']");
	      By txtOpposingAppraiser = By.xpath("//input[contains(@id,'Opposing_Appraiser') and @type='text']");
	      By txtOpposingAppraisalValue = By.xpath("//input[contains(@id,'Opposing_Appraisal_Value') and @type='text']");
	    //T4 Information
	      By txtObjectionFieldDate = By.xpath("//input[contains(@id,'_T4Objection_Filed_Date_dateInput') and @type='text']");
	      By RequestedDateForT4Information = By.xpath("//input[contains(@id,'_T4Requested_Date_dateInput') and @type='text']");
	      By txtAppliedForDate = By.xpath("//input[contains(@id,'_T4Applied_Date_dateInput') and @type='text']");
	      By txtReceivedDateT4Information  = By.xpath("//input[contains(@id,'_T4Received_Date_dateInput') and @type='text']");
	      By txtApprovedDateT4Information = By.xpath("//input[contains(@id,'_T4Approved_Date_dateInput') and @type='text']");
	      By txtTarrifFiledDate = By.xpath("//input[contains(@id,'_Tariff_Filed_Date_dateInput') and @type='text']");
	     //Condemnation Survey
	      By txtSurveyPlatDeadlineDate = By.xpath("//input[contains(@id,'_SURVEY_PLAT_DEADLINE_dateInput') and @type='text']");
	      By txtRequestedSurveyDate = By.xpath("//input[contains(@id,'_SURVEY_PLAT_REQ_DATE_dateInput') and @type='text']");
	      By txtReceivedSurveyDate = By.xpath("//input[contains(@id,'_SURVEY_PLAT_REC_DATE_dateInput') and @type='text']");
	      //Condemnation Package
	      By txtInhouseLegalDate = By.xpath("//input[contains(@id,'_INHOUSE_LEGAL_DATE_dateInput') and @type='text']");
	      By txtOutsideLegalDate = By.xpath("//input[contains(@id,'_OUTSIDE_LEGAL_DATE_dateInput') and @type='text']");
	     //Case Information
	      By txtLisPendensFiledDate = By.xpath("//input[contains(@id,'_Lis_Pendens_Filed_Date_dateInput') and @type='text']");
	      By txtSCHearingDate = By.xpath("//input[contains(@id,'_HEARING_DATE_dateInput') and @type='text']");
	      By txtAction = By.xpath("//input[contains(@id,'CASE_NUM') and @type='text']");
	      By txtAwardAmount = By.xpath("//input[contains(@id,'AWARD_AMOUNT') and @type='text']");
	      By txtPossessionDate = By.xpath("//input[contains(@id,'_POSSESSION_DATE_dateInput') and @type='text']");
	      By txtValuationHearingDate = By.xpath("//input[contains(@id,'_VALUATION_HEARING_dateInput') and @type='text']");
	      By txtAttorney = By.xpath("//input[contains(@id,'_EditFormControl_Attorney') and @type='text']");
	      By textValuationHearingDate = By.xpath("//input[contains(@id,'Opposing_Attorney') and @type='text']");
	      By CheckObjectionFiledcheckbox = By.xpath("//input[contains(@id,'_AwardObjectionFiled') and @type='checkbox']");
	     //Condemnation Bond 
	      By txtSignedDate = By.xpath("(//input[contains(@id,'_BOND_SIGNED_DATE_dateInput') and @type='text'])[1]");
	      By txtBondAmount = By.xpath("//input[contains(@id,'BOND_AMOUNT') and @type='text']");
	      By txtReleasedDate = By.xpath("(//input[contains(@id,'_BOND_RELEASE_DATE_dateInput') and @type='text'])[1]");
	     //Cost Bond
	      By txtSignedDateForCostBond = By.xpath("//input[contains(@id,'_COST_BOND_SIGNED_DATE_dateInput') and @type='text']");
	      By txtAmountForCostBond = By.xpath("//input[contains(@id,'COST_BOND_AMT') and @type='text']");
	      By txtReleasedDateForCostBond = By.xpath("//input[contains(@id,'_COST_BOND_RELEASE_DATE_dateInput') and @type='text']");
	      By btnSave = By.xpath("//input[@id='ctl00_ConPHRightTop_TRLG_UC_radPanels_i2_i0_radGridLegal_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_btnInsert']");
	      By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");

	     
	      public void ClickonAddNewButton() {
	    	  util.waitUntilElementDisplay(btnAddNew);
	    	  util.click(btnAddNew);
	      }

	      public void AddCondemnationName(String value) {
	    		if (!commonFunction.checkNA(value))
					util.inputTextAndPressTab(txtCondemnationName, value);
	      }
	      
	      public void AddAssignedTo(String value) {
	  		if (!commonFunction.checkNA(value))
					util.inputTextAndPressTab(txtAssignedTo, value);
	     }
	      
	      public void AddAssignedDate(String value) {
	    		if (!commonFunction.checkNA(value))
	  				util.inputTextAndPressTab(txtAssignedDate, value);
	      }
	      
	      public void AddInternalNotificationDate(String value) {
	  		if (!commonFunction.checkNA(value))
					util.inputTextAndPressTab(txtInternalNotificationDate, value);
	      }
	      
	      public void ClickonCondemnationCheckBox() {
	    	  util.waitUntilElementDisplay(CondemnationCheckBox);
	    	  util.click(CondemnationCheckBox);
	      }
	      
	      public void AddComment(String value) {
	    		if (!commonFunction.checkNA(value))
	  				util.inputTextAndPressTab(txtComment, value);
	      }
	      
	      public void AddNonSuitDate(String value) {
	  		if (!commonFunction.checkNA(value))
					util.inputTextAndPressTab(txtNonSuitDate, value);
	      }
	      
	      public void AddOriginalPetitionDate(String value) {
	    		if (!commonFunction.checkNA(value))
	  				util.inputTextAndPressTab(txtOriginalPetitionDate, value);
	      }
	      
	      public void AddCause(String value) {
	  		if (!commonFunction.checkNA(value))
					util.inputTextAndPressTab(txtCause, util.randomNumber());
	     }
	      
	      public void AddRequestedDate(String value) {
	    		if (!commonFunction.checkNA(value))
	  				util.inputTextAndPressTab(txtRequestedDate, value);
	      }
	      
	      public void AddReceivedDate(String value) {
	  		if (!commonFunction.checkNA(value))
					util.inputTextAndPressTab(txtReceivedDate, value);
	     }
	      
	      public void AddSentDate(String value) {
	    		if (!commonFunction.checkNA(value))
	  				util.inputTextAndPressTab(txtSentDate, value);
	     }
	      
	      public void AddAmount(String value) {
	  		if (!commonFunction.checkNA(value))
					util.inputTextAndPressTab(txtAmount, value);
	     }
	      
	      public void SelectResponse(String value) {
	    		if (!commonFunction.checkNA(value))
	  				util.inputTextAndPressTab(SelectResponse, value);
	       }
	      
	      public void AddSentDateForLetterofIntent(String value) {
	  		if (!commonFunction.checkNA(value))
					util.inputTextAndPressTab(txtSentDateForLetter, value);
	      }
	      
	      public void SelectResponseForLetterofIntent(String value) {
	    		if (!commonFunction.checkNA(value))
	  				util.inputTextAndPressTab(SelectResponseForLetter, value);
	      }
	      
	      public void AddCauseForTRO(String value) {
	  		if (!commonFunction.checkNA(value))
					util.inputTextAndPressTab(txtCauseForTRO, util.randomNumber());
	      }
	      
	      public void AddTempInjunctionHearingDate (String value) {
	    		if (!commonFunction.checkNA(value))
	  				util.inputTextAndPressTab(txtTempInjunctionHearingDate , value);
	      }
	      
	      public void AddTROHearingDate (String value) {
	  		if (!commonFunction.checkNA(value))
					util.inputTextAndPressTab(txtTROHearingDate , value);
	      }
	      
	      public void AddT1HearingDate (String value) {
	    		if (!commonFunction.checkNA(value))
	  				util.inputTextAndPressTab(txtT1HearingDate , value);
	        }
	      
	      public void AddSentDateForFinalWrittenOffer (String value) {
	  		if (!commonFunction.checkNA(value))
					util.inputTextAndPressTab(txtSentDateForFinal , value);
	      }
	      
	      public void AddAmountForFinalWrittenOffer (String value) {
	    		if (!commonFunction.checkNA(value))
	  				util.inputTextAndPressTab(txtAmountForFinal , value);
	      }
	      
	      public void SelectResponseForFinalWrittenOffer (String value) {
	  		if (!commonFunction.checkNA(value))
					util.inputTextAndPressTab(SelectResponseForFinal , value);
	    }
	      
	      public void ClickonLOBORIncludedCheckbox () {
	    	  util.waitUntilElementDisplay(LOBORIncludedCheckbox);
	    	  util.click(LOBORIncludedCheckbox);
	      }
	      
	      public void AddRequestedDateForCondemnationTitle (String value) {
	  		if (!commonFunction.checkNA(value))
					util.inputTextAndPressTab(RequestedDateCondemnationTitle , value);
	     }
	      
	      public void AddReceivedDateForCondemnationTitle (String value) {
	    		if (!commonFunction.checkNA(value))
	  				util.inputTextAndPressTab(ReceivedDateCondemnationTitle , value);
	       }

	      public void AddRequestedDateCondemnationAppraisal (String value) {
	  		if (!commonFunction.checkNA(value))
					util.inputTextAndPressTab(RequestedDateCondemnationAppraisal , value);
	     }

	      public void AddReceivedDateCondemnationAppraisal (String value) {
	   		if (!commonFunction.checkNA(value))
	 				util.inputTextAndPressTab(ReceivedDateCondemnationAppraisal , value);
	      }
	      
	      public void AddProducedDate (String value) {
	     		if (!commonFunction.checkNA(value))
	   				util.inputTextAndPressTab(txtProducedDate , value);
	        }
	      
	      public void AddAppraisalCompany (String value) {
	   		if (!commonFunction.checkNA(value))
	 				util.inputTextAndPressTab(txtAppraisalCompany , value);
	      }
	      
	      public void AddAppraisalValue (String value) {
	     		if (!commonFunction.checkNA(value))
	   				util.inputTextAndPressTab(txtAppraisalValue , value);
	       }
	      
	      public void AddAppraisalRequestedCancelledDate (String value) {
	   		if (!commonFunction.checkNA(value))
	 				util.inputTextAndPressTab(AppraisalRequestedCancelledDate , value);
	      }
	      
	      public void AddOpposingAppraiser (String value) {
	     		if (!commonFunction.checkNA(value))
	   				util.inputTextAndPressTab(txtOpposingAppraiser , value);
	       }
	      
	      public void AddOpposingAppraisalValue (String value) {
	   		if (!commonFunction.checkNA(value))
	 				util.inputTextAndPressTab(txtOpposingAppraisalValue , value);
	     }
	      
	      public void AddObjectionFieldDate (String value) {
	     		if (!commonFunction.checkNA(value))
	   				util.inputTextAndPressTab(txtObjectionFieldDate , value);
	       }
	      
	      public void AddRequestedDateForT4Information (String value) {
	   		if (!commonFunction.checkNA(value))
	 				util.inputTextAndPressTab(RequestedDateForT4Information , value);
	     }
	      
	      public void AddAppliedForDate(String value) {
	     		if (!commonFunction.checkNA(value))
	   				util.inputTextAndPressTab(txtAppliedForDate , value);
	       }
	     
	      public void AddReceivedDateT4Information(String value) {
	    		if (!commonFunction.checkNA(value))
	  				util.inputTextAndPressTab(txtReceivedDateT4Information , value);
	      }
	      
	      public void AddApprovedDateT4Information(String value) {
	  		if (!commonFunction.checkNA(value))
					util.inputTextAndPressTab(txtApprovedDateT4Information , value);
	     }
	      
	      public void AddTarrifFiledDate(String value) {
	    		if (!commonFunction.checkNA(value))
	  				util.inputTextAndPressTab(txtTarrifFiledDate , value);
	      }
	      
	      public void AddSurveyPlatDeadlineDate(String value) {
	  		if (!commonFunction.checkNA(value))
					util.inputTextAndPressTab(txtSurveyPlatDeadlineDate , value);
	      }
	      
	      public void AddRequestedSurveyDate(String value) {
	    		if (!commonFunction.checkNA(value))
	  				util.inputTextAndPressTab(txtRequestedSurveyDate , value);
	      }
	      
	      public void AddReceivedSurveyDate(String value) {
	  		if (!commonFunction.checkNA(value))
					util.inputTextAndPressTab(txtReceivedSurveyDate , value);
	      }
	      
	      public void AddInhouseLegalDate(String value) {
	    		if (!commonFunction.checkNA(value))
	  				util.inputTextAndPressTab(txtInhouseLegalDate , value);
	        }
	      
	     
	      public void AddOutsideLegalDate(String value) {
	    		if (!commonFunction.checkNA(value))
	  				util.inputTextAndPressTab(txtOutsideLegalDate  , value);
	        }
	      
	      public void AddLisPendensFiledDate(String value) {
	    		if (!commonFunction.checkNA(value))
	  				util.inputTextAndPressTab(txtLisPendensFiledDate  , value);
	        }
	        
	      
	      public void AddSCHearingDate(String value) {
	  		if (!commonFunction.checkNA(value))
					util.inputTextAndPressTab(txtSCHearingDate  , value);
	      }
	      
	      public void AddAction(String value) {
	    		if (!commonFunction.checkNA(value))
	  				util.inputTextAndPressTab(txtAction  , value);
	      }
	      
	      public void AddAwardAmount(String value) {
	  		if (!commonFunction.checkNA(value))
					util.inputTextAndPressTab(txtAwardAmount  , value);
	     }
	      
	      public void AddPossessionDate(String value) {
	    		if (!commonFunction.checkNA(value))
	  				util.inputTextAndPressTab(txtPossessionDate , value);
	       }
	      
	      public void AddValuationHearingDate(String value) {
	  		if (!commonFunction.checkNA(value))
					util.inputTextAndPressTab(txtValuationHearingDate , value);
	     }
	      
	      public void AddAttorney(String value) {
	    		if (!commonFunction.checkNA(value))
	  				util.inputTextAndPressTab(txtAttorney , value);
	       }
	      
	      public void EnterValuationHearingDate(String value) {
	  		if (!commonFunction.checkNA(value))
					util.inputTextAndPressTab(textValuationHearingDate , value);
	     }
	      
	      public void CheckObjectionFiledcheckbox() {
	    	     util.waitUntilElementDisplay(CheckObjectionFiledcheckbox);
	    	     util.click(CheckObjectionFiledcheckbox);
	       }
	       
	      public void AddSignedDate(String value) {
	  		if (!commonFunction.checkNA(value))
					util.inputTextAndPressTab(txtSignedDate , value);
	     }
	      
	      public void AddBondAmount(String value) {
	    		if (!commonFunction.checkNA(value))
	  				util.inputTextAndPressTab(txtBondAmount , value);
	       }
	      
	      public void AddReleasedDate(String value) {
	  		if (!commonFunction.checkNA(value))
					util.inputTextAndPressTab(txtReleasedDate , value);
	     }
	      
	      public void AddSignedDateForCostBond(String value) {
	    		if (!commonFunction.checkNA(value))
	  				util.inputTextAndPressTab(txtSignedDateForCostBond , value);
	       }
	      
	      public void AddAmountForCostBond(String value) {
	  		if (!commonFunction.checkNA(value))
					util.inputTextAndPressTab(txtAmountForCostBond , value);
	     }
	      
	      public void AddReleasedDateForCostBond(String value) {
	    		if (!commonFunction.checkNA(value))
	  				util.inputTextAndPressTab(txtReleasedDateForCostBond , value);
	       }
	      
	      public void ClickonSaveButton() {
	    	  util.waitUntilElementDisplay(btnSave);
	    	  util.click(btnSave);
	    	  util.waitUntilElementDisplay(changesSavedSuccessfully);
	  		Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
                 util.dummyWait(2);
	      }
	      
	      public void AddCondemnationRecord(Map<String, String> map, String testcaseName) {
	    	
	    	  try {
	    		  ClickonAddNewButton();
	  			log("STEP 1: Record Grid should expands below ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 1:  Record does not expand below", Status.FAIL);
	  			throw new RuntimeException("Failed in step 1");
	  		}
	    	  
	    	  try {
	    		  AddCondemnationName(map.get(Excel.CondemnationName));
	  			log("STEP 2: Entered value should display in the Condemnation Name field  ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 2: Entered value does not display in Condemnation Name field. ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 2");
	  		}
	    	  
	    	  try {
	    		  AddAssignedTo(map.get(Excel.AssignedTo));
	  			log("STEP 3: Entered value should display in the Assigned To field ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 3: Entered value does not display in Assigned To field. ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 3");
	  		}
	    	  
	    	  try {
	    		  AddAssignedDate(map.get(Excel.AssignedDate));
	  			log("STEP 4: User can select the  Assigned Date   ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 4: User  cannot select  Date  from Date Picker  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 4");
	  		}
	    	  
	    	  try {
	    		  AddInternalNotificationDate(map.get(Excel.InternalNotificationDate));
	  			log("STEP 5: User can select the  Internal Notification Date   ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 5: User  cannot select  Date  from Date Picker ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 5");
	  		}
	    	  
	    	  try {
	    		  ClickonCondemnationCheckBox();
	  			log("STEP 6: Condemnation By Publication checkbox should be display checked  ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 6: Condemnation By Publication checkbox does not display checked ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 6");
	  		}
	    	  
	    	  try {
	    		  AddComment(map.get(Excel.Comment));
	  			log("STEP 7: Entered value should display in the Comments field.  ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 7: Entered value does not display in Comments field. ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 7");
	  		} 
	    	
	    	  try {
	    		  AddNonSuitDate(map.get(Excel.NonSuitDate));
	  			log("STEP 8:  User can select the  Non Suit Date ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 8: User  cannot select  Date  from Date Picker  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 8");
	  		}
	    	  
	    	  try {
	    		  AddOriginalPetitionDate(map.get(Excel.OriginalPetitionDate));
	  			log("STEP 9:  User can select the  Original Petition Date ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 9: User  cannot select  Date  from Date Picker  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 9");
	  		}
	    	  
	    	  try {
	    		  AddCause(map.get(Excel.Cause));
	  			log("STEP 10: Entered value should display in the Cause # field. ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 10: Entered value does not display in Cause # field ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 10");
	  		}
	    	  
	    	  try {
	    		  AddRequestedDate(map.get(Excel.RequestedDate));
	  			log("STEP 11:  User can select the  Requested Date  ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 11: User  cannot select  Date  from Date Picker  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 11");
	  		}
	    	  
	    	  try {
	    		  AddReceivedDate(map.get(Excel.ReceivedDate));
	  			log("STEP 12:  User can select the  Received Date   ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 12: User  cannot select  Date  from Date Picker   ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 12");
	  		} 
	    	  
	    	  try {
	    		  AddSentDate(map.get(Excel.SentDate));
	  			log("STEP 13:  User can select the  Sent Date  ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 13: User  cannot select  Date  from Date Picker   ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 13");
	  		} 
	    	  
	    	  try {
	    		  AddAmount(map.get(Excel.Amount));
	  			log("STEP 14: Entered value should display in the Amount field.  ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 14: Entered value does not display in Amount field.  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 14");
	  		} 
	    	  
	    	  try {
	    		  SelectResponse(map.get(Excel.Response));
	  			log("STEP 15: Selected value display in the  Response DD  ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 15: selected value does not display in  Response DD.  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 15");
	  		}
	    	  
	    	  try {
	    		  AddSentDateForLetterofIntent(map.get(Excel.SentDate));
	  			log("STEP 16:  User can select the  Sent Date  ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 16: User  cannot select  Date  from Date Picker  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 16");
	  		}
	    	  
	    	  try {
	    		  SelectResponseForLetterofIntent(map.get(Excel.ResponseLetter));
	  			log("STEP 17: Selected value display in the  Response DD   ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 17: selected value does not display in  Response DD.  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 17");
	  		}
	    	  
	    	  try {
	    		  AddCauseForTRO(map.get(Excel.Cause));
	  			log("STEP 18:  Entered value should display in the Cause # field. ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 18: Entered value does not display in Cause # field. ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 18");
	  		} 
	    	  
	    	  try {
	    		  AddTempInjunctionHearingDate(map.get(Excel.TempInjunctionHearingDate));
	  			log("STEP 19: User can select the  Temp Injunction Hearing Date  ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 19: User  cannot select  Date  from Date Picker  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 19");
	  		} 
	    	  
	    	  
	    	  try {
	    		  AddTROHearingDate(map.get(Excel.TROHearingDate));
	  			log("STEP 20: User can select the  TRO Hearing Date  ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 20: User  cannot select  Date  from Date Picker  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 20");
	  		} 
	    	  
	    	  try {
	    		  AddT1HearingDate(map.get(Excel.T1HearingDate));
	  			log("STEP 21: User can select the  T1 Hearing Date  ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 21: User  cannot select  Date  from Date Picker  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 21");
	  		} 
	    	  
	    	  try {
	    		  AddSentDateForFinalWrittenOffer(map.get(Excel.SentDate));
	  			log("STEP 22: User can select the  Sent Date For Final Written Offer  ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 22: User  cannot select  Date  from Date Picker  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 22");
	  		} 
	    	  
	    	  try {
	    		  AddAmountForFinalWrittenOffer(map.get(Excel.Amount));
	  			log("STEP 23: Entered value should display in the Amount field.  ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 23: Entered value does not display in Amount field. ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 23");
	  		} 
	    	  
	    	  try {
	    		  SelectResponseForFinalWrittenOffer(map.get(Excel.Response));
	  			log("STEP 24: Selected value display in the Response DD ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 24: No value displays in the Dropdown ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 24");
	  		}
	    	  
	    	  
	    	  try {
	    		  ClickonLOBORIncludedCheckbox();
	  			log("STEP 25: LOBOR Included checkbox should be display checked ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 25: LOBOR Included checkbox does not display checked ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 25");
	  		}  
	    	  
	    	  try {
	    		  AddRequestedDateForCondemnationTitle(map.get(Excel.RequestedDate));
	  			log("STEP 26: User can select the  Requested Date  ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 26: User  cannot select  Date  from Date Picker  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 26");
	  		}
	    	  
	    	  try {
	    		  AddReceivedDateForCondemnationTitle(map.get(Excel.ReceivedDate));
	  			log("STEP 27: User can select the  Received Date  ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 27: User  cannot select  Date  from Date Picker  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 27");
	  		}
	    	  
	    	  try {
	    		  AddRequestedDateCondemnationAppraisal(map.get(Excel.RequestedDate));
	  			log("STEP 28: User can select the  Requested Date  ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 28: User  cannot select  Date  from Date Picker  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 28");
	  		}
	    	  
	    	  
	    	  try {
	    		  AddReceivedDateCondemnationAppraisal(map.get(Excel.ReceivedDate));
	  			log("STEP 29: User can select the  Received Date  ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 29: User  cannot select  Date  from Date Picker  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 29");
	  		}
	    	  
	    	  try {
	    		  AddProducedDate(map.get(Excel.ProducedDate));
	  			log("STEP 30: User can select the  Produced Date  ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 30: User  cannot select  Date  from Date Picker  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 30");
	  		} 
	    	  
	    	  try {
	    		  AddAppraisalCompany(map.get(Excel.AppraisalCompany));
	  			log("STEP 31: Selected value display in the  Appraisal Company DD  ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 31: selected value does not display in  Appraisal Company DD.  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 31");
	  		} 
	    	  
	    	  try {
	    		  AddAppraisalValue(map.get(Excel.AppraisalValue));
	  			log("STEP 32: Entered value should display in the Appraisal Value field. ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 32:Entered value does not display in Appraisal Value field. ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 32");
	  		} 
	    	  
	    	  try {
	    		  AddAppraisalRequestedCancelledDate(map.get(Excel.CancelledDate));
	  			log("STEP 33: User can select the  Cancelled Date  ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 33: User  cannot select  Date  from Date Picker  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 33");
	  		} 
	    	  
	    	  try {
	    		  AddOpposingAppraiser(map.get(Excel.OpposingAppraiser));
	  			log("STEP 34: Entered value should display in the Opposing Appraiser field.  ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 34: Entered value does not display in Opposing Appraiser field. ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 34");
	  		} 
	    	  
	    	  try {
	    		  AddOpposingAppraisalValue(map.get(Excel.OpposingAppraisalValue));
	  			log("STEP 35: Entered value should display in the Opposing Appraisal Value field. ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 35: Entered value does not display in Opposing Appraisal Value field.  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 35");
	  		} 
	    	  
	    	  try {
	    		 AddObjectionFieldDate(map.get(Excel.ObjectionFieldDate));
	  			log("STEP 36: User can select the  Objection Field Date  ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 36: User  cannot select  Date  from Date Picker  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 36");
	  		} 
	    	  
	    	  try {
	    		  AddRequestedDateForT4Information(map.get(Excel.RequestedDate));
	   			log("STEP 37: User can select the  Requested Date  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 37: User  cannot select  Date  from Date Picker  ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 37");
	   		}
	    	  
	    	  try {
	    		  AddAppliedForDate(map.get(Excel.AppliedForDate));
	   			log("STEP 38: User can select the  Applied For Date  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 38: User  cannot select  Date  from Date Picker  ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 38");
	   		}
	    	  
	    	  try {
	    		  AddReceivedDateT4Information(map.get(Excel.ReceivedDate));
	   			log("STEP 39: User can select the  Received Date T4Information  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 39: User  cannot select  Date  from Date Picker  ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 39");
	   		}
	    	  
	    	  try {
	    		  AddApprovedDateT4Information(map.get(Excel.ApprovedDate));
	   			log("STEP 40: User can select the  Approved Date T4Information  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 40: User  cannot select  Date  from Date Picker  ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 40");
	   		}
	    	
	    	  
	    	  try {
	    		  AddTarrifFiledDate(map.get(Excel.TarrifFiledDate));
	   			log("STEP 41: User can select the  Tarrif Filed Date  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 41: User  cannot select  Date  from Date Picker  ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 41");
	   		}
	    	  
	    	  try {
	    		  AddSurveyPlatDeadlineDate(map.get(Excel.PlatDeadlineDate));
	   			log("STEP 42: User can select the  Survey Plat Deadline Date  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 42: User  cannot select  Date  from Date Picker  ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 42");
	   		} 
	    	 
	    	  try {
	    		  AddRequestedSurveyDate(map.get(Excel.RequestedDate));
	   			log("STEP 43: User can select the  Requested Survey Date  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 43: User  cannot select  Date  from Date Picker  ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 43");
	   		} 
	    	 
	    	  
	    	  try {
	    		  AddReceivedSurveyDate(map.get(Excel.ReceivedDate));
	   			log("STEP 44: User can select the  Received Survey Date  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 44: User  cannot select  Date  from Date Picker  ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 44");
	   		}
	    	  
	    	  try {
	    		  AddInhouseLegalDate(map.get(Excel.InhouseLegalDate));
	   			log("STEP 45: User can select the  Inhouse Legal Date  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 45: User  cannot select  Date  from Date Picker  ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 45");
	   		}
	    	 
	    	  try {
	    		  AddOutsideLegalDate(map.get(Excel.OutsideLegalDate));
	   			log("STEP 46: User can select the  Outside Legal Date  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 46: User  cannot select  Date  from Date Picker  ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 46");
	   		}
	    	  
	    	  try {
	    		  AddLisPendensFiledDate(map.get(Excel.LisPendensFiledDate));
	   			log("STEP 47: User can select the  Lis Pendens Filed Date  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 47: User  cannot select  Date  from Date Picker  ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 47");
	   		}
	    	  
	    	  try {
	    		  AddSCHearingDate(map.get(Excel.SCHearingDate));
	   			log("STEP 48: User can select the  SCHearing Date  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 48: User  cannot select  Date  from Date Picker  ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 48");
	   		}
	    	  
	    	  try {
	    		  AddAction(map.get(Excel.Action));
	   			log("STEP 49: Entered value should display in the Case/Action # field ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 49: Entered value does not display in Case/Action # field. ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 49");
	   		}
	    	  
	    	  try {
	    		  AddAwardAmount(map.get(Excel.Amount));
	   			log("STEP 50: Entered value should display in the Award Amount field. ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 50: Entered value does not display in Award Amount field ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 50");
	   		}
	    	  
	    	  try {
	    		  AddPossessionDate(map.get(Excel.PossessionDate));
	   			log("STEP 51: User can select the  Possession Date ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 51: User  cannot select  Date  from Date Picker ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 51");
	   		}
	    	  
	    	  try {
	    		  AddValuationHearingDate(map.get(Excel.ValuationHearingDate));
	   			log("STEP 52: User can select the  Valuation Hearing Date ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 52: User  cannot select  Date  from Date Picker ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 52");
	   		}
	    	  
	    	  try {
	    		  AddAttorney(map.get(Excel.Attorney));
	   			log("STEP 53: Entered value should display in the Attorney field.  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 53: Entered value does not display in Attorney field. ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 53");
	   		}
	    	  
	    	  try {
	    		  EnterValuationHearingDate(map.get(Excel.ValuationHearingDate));
	   			log("STEP 54: User can select the  Valuation Hearing Date ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 54: User  cannot select  Date  from Date Picker ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 54");
	   		}
	    	 
	    	  
	    	  try {
	    		  CheckObjectionFiledcheckbox();
	   			log("STEP 55: Entered value should display in the Valuation Hearing Date field. ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 55: Entered value does not display in Valuation Hearing Date field. ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 55");
	   		}
	    	  
	    	  
	    	  try {
	    		  AddSignedDate(map.get(Excel.SignedDate));
	   			log("STEP 56: User can select the  Signed Date ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 56: User  cannot select  Date  from Date Picker ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 56");
	   		}
	    	  
	    	  
	    	  try {
	    		  AddBondAmount(map.get(Excel.BondAmount));
	   			log("STEP 57: Entered value should display in the Bond Amount field. ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 57: Entered value does not display in Bond Amount field. ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 57");
	   		}
	    	  
	    	  
	    	  try {
	    		  AddReleasedDate(map.get(Excel.ReleasedDate));
	   			log("STEP 58: User can select the  Date ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 58: User  cannot select  Date  from Date Picker ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 58");
	   		}
	    	  
	    	  try {
	    		  AddSignedDateForCostBond(map.get(Excel.SignedDate));
	   			log("STEP 59: User can select the  Signed Date For Cost Bond ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 59: User  cannot select  Date  from Date Picker ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 59");
	   		}
	    	  
	    	  try {
	    		  AddAmountForCostBond(map.get(Excel.Amount));
	   			log("STEP 60: Entered value should display in the Amount field.  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 60: Entered value does not display in Amount field. ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 60");
	   		} 
	    	  
	    	  try {
	    		  AddReleasedDateForCostBond(map.get(Excel.ReleasedDate));
	   			log("STEP 61: User can select the  Released Date For CostBond ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 61: User  cannot select  Date  from Date Picker ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 61");
	   		}
	    	  
	    	  
	    	  try {
	    		  ClickonSaveButton();
	   			log("STEP 62:  Message - 'Message - 'Changes saved successfully' in green displays ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 62: Message - 'Message - 'Changes saved successfully' does not displays  ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 62");
	   		}
	    	  
	    	  
	      }
}
