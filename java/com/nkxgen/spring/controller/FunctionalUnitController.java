package com.nkxgen.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nkxgen.spring.orm.model.FunctionalUnitdto;
import com.nkxgen.spring.orm.model.FunctionalUnitinput;
import com.nkxgen.spring.orm.service.FunctionalUnitService;

@Controller
public class FunctionalUnitController {
	FunctionalUnitService Funitservice;

	@Autowired
	public FunctionalUnitController(FunctionalUnitService Funitservice) {
		this.Funitservice = Funitservice;
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/funitsbymodlId", method = RequestMethod.GET)
	public String getModuleDetailsByProjId(@RequestParam("modId") Integer modId, Model model) {
		System.out.println("Functional unit jsp called");
		System.out.println("funitid " + modId);
		List<FunctionalUnitdto> funits = Funitservice.getFunctionalunitByModId(modId);
		System.out.println("funity data" + funits);
		model.addAttribute("funitdto", funits);
		return "funitsbymodlId";
	}

	@RequestMapping(value = "/createfunit", method = RequestMethod.GET)
	public String createnewFunit() {

		return "createfunit";
	}

	@RequestMapping(value = "/createFunitsuccess", method = RequestMethod.POST)
	public String Createmodulesuccess(@Validated FunctionalUnitinput Funitinput, Model model) {
	    System.out.println("createModule jsp called");
	    System.out.println(Funitinput);
	    Funitservice.createFunit(Funitinput);
	    Integer modId = Funitinput.getModl_id(); // Assuming you have a method to retrieve the module ID from the input object
	    return "redirect:/funitsbymodlId?modId=" + modId;
	}

	// @RequestMapping(value = "/", method = RequestMethod.GET)
	// public String funit(Model m,@RequestParam("modl_id)Integer modl_id) {
	// ArrayList<FunitModel> f1 = (ArrayList<FunitModel>) functionalUnitDao.getfunitbyid(modl_id);
	// m.addAttribute("f1", f1);
	// System.out.println(f1 + " " + "controller");
	// return "funit";
	// }
	//
	// @RequestMapping(value = "/create")
	// public String createfunit() {
	// return "create";
	// }
	//
	// // @RequestMapping(value = "/", method = RequestMethod.GET)
	// // public String targetPage(HttpSession session, Model model) {
	// // // Retrieve the ID from the session
	// // int id = (int) session.getAttribute("id");
	// //
	// // // Pass the ID to the DAO to retrieve data
	// // ArrayList<FunitModel> f1 = (ArrayList<FunitModel>) p.getfunitbyid(id);
	// //
	// // // Add the retrieved data to the model
	// // model.addAttribute("f1", f1);
	// //
	// // // Return the view name for the target page
	// // return "targetPage";
	// // }
	// @PostMapping("/newfunit")
	// public String newfunit(@RequestParam("modl_id") int modl_id, @RequestParam("f_unit_id") int funit_id) {
	// functionalUnitDao.createmodel(modl_id, funit_id); // Modify the method call as per your DAO implementation
	// return "redirect:/"; // Redirect back to the main page after form submission
	// }
	// Other controller methods

}