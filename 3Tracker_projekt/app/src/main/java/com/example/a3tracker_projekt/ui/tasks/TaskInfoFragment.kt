package com.example.a3tracker_projekt.ui.tasks

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.a3tracker_projekt.ui.groups.GroupViewModel
import com.example.projekt.R
import java.text.SimpleDateFormat

class TaskInfoFragment : Fragment() {

//    private lateinit var taskListViewModel: TaskViewModel
//    private lateinit var title: TextView
//    private lateinit var createdTime: TextView
//    private lateinit var creator: TextView
//    private lateinit var assignee: TextView
//    private lateinit var department: TextView
//    private lateinit var deadline: TextView
//    private lateinit var priority: TextView
//    private lateinit var status: TextView
//    private lateinit var progress: TextView
//    private lateinit var description: TextView
//    private lateinit var backButton: ImageButton
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val factory = TaskViewModelFactory(TrackerRepository())
//        taskListViewModel = ViewModelProvider(this, factory).get(TaskViewModel::class.java)
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_task_info, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        view.apply {
//            initViewItems(this)
//            registerListeners()
//        }
//        title.text = taskListViewModel.currentTask.title
//        createdTime.text = taskListViewModel.currentTask.created_time.toString()
//        creator.text = taskListViewModel.currentTaskInfo.created_by_user
//        assignee.text = taskListViewModel.currentTaskInfo.assigned_to_user
//        department.text = taskListViewModel.currentTaskInfo.department
//        deadline.text = taskListViewModel.currentTask.deadline.toString()
//        priority.text = taskListViewModel.currentTask.priority.toString()
//        status.text = taskListViewModel.currentTask.status.toString()
//        progress.text = taskListViewModel.currentTask.progress.toString()
//        description.text = taskListViewModel.currentTask.description
//    }
//
//    private fun registerListeners() {
//        backButton.setOnClickListener {
//            findNavController().navigate(R.id.taskFragment)
//        }
//    }
//
//    private fun initViewItems(view: View) {
//        title = view.findViewById(R.id.taskInfoTitle)
//        createdTime = view.findViewById(R.id.taskInfoTime)
//        creator = view.findViewById(R.id.taskInfoCreator)
//        assignee = view.findViewById(R.id.taskInfoAssignee)
//        department = view.findViewById(R.id.taskInfoDepartment)
//        deadline = view.findViewById(R.id.taskInfoDeadline)
//        priority = view.findViewById(R.id.taskInfoPriority)
//        status = view.findViewById(R.id.taskInfoStatus)
//        progress = view.findViewById(R.id.taskInfoProgress)
//        description = view.findViewById(R.id.taskInfoDescription)
//        backButton = view.findViewById(R.id.backButton)
//    }

    private val groupsVM: GroupViewModel by activityViewModels()
    private val taskID = taskTitle
    private lateinit var taskTitle: TextView
    private lateinit var statusDropdown: Spinner
    private lateinit var groupName: TextView
    private lateinit var assignedBy: TextView
    private lateinit var assignedDate: TextView
    private lateinit var assignee: TextView
    private lateinit var progress: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var deadline: TextView
    private lateinit var priority: TextView
    private lateinit var lowPrioImg: ImageView
    private lateinit var mediumPrioImg: ImageView
    private lateinit var highPrioImg: ImageView
    private lateinit var description: TextView
    private lateinit var backButton: ImageView
    val filters = listOf("New","In Progress","Blocked","Done")
    private val tasksVM : TaskViewModel by activityViewModels()
    private val usersVM: UsersViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewItems()
        registerListeners()
    }

    private fun registerListeners() {
        /*statusDropdown.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedOption = statusDropdown.selectedItem as String
                if (selectedOption == filters[0]){
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }*/

        backButton.setOnClickListener {
            replaceFragment(TaskFragment())
        }
    }

    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    private fun initViewItems() {
        val task = tasksVM.getTaskById(taskID)
        val dateformat2 = SimpleDateFormat("MMMM dd yyyy")
        taskTitle = requireView().findViewById(R.id.taskTitle)
        taskTitle.text = task!!.title
        /*statusDropdown= requireView().findViewById(R.id.statusDropdown)
        val adapter = context?.let { ArrayAdapter(it,android.R.layout.simple_spinner_item,filters) }
        adapter!!.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        statusDropdown.adapter = adapter*/
        groupName = requireView().findViewById(R.id.groupName)
        groupName.text = groupsVM.getGroupById(task.groupId)
        assignedBy = requireView().findViewById(R.id.assignedBy)
        assignedBy.text = usersVM.getName(task.createdBy)
        assignedDate = requireView().findViewById(R.id.assignedDate)
        assignedDate.text = dateformat2.format(task.createdAt)
        assignee = requireView().findViewById(R.id.assigneeName)
        assignee.text = usersVM.getName(task.assignee)
        progress = requireView().findViewById(R.id.percentDoneText)
        progress.text = task.progress.toString()
        progressBar = requireView().findViewById(R.id.progressBar)
        progressBar.progress = task.progress
        deadline = requireView().findViewById(R.id.deadlineDate)
        deadline.text = dateformat2.format(task.deadline)
        priority = requireView().findViewById(R.id.priorityText)
        lowPrioImg = requireView().findViewById(R.id.lowPrioIcon)
        mediumPrioImg = requireView().findViewById(R.id.mediumPrioIcon)
        highPrioImg = requireView().findViewById(R.id.highPrioIcon)
//        when(task.priority){
//            TaskPriority.LOW->{
//                priority.text = "Low priority"
//                lowPrioImg.visibility=View.VISIBLE
//                mediumPrioImg.visibility=View.GONE
//                highPrioImg.visibility=View.GONE
//            }
//            TaskPriority.MEDIUM->{
//                priority.text = "Medium priority"
//                lowPrioImg.visibility=View.GONE
//                mediumPrioImg.visibility=View.VISIBLE
//                highPrioImg.visibility=View.GONE
//            }
//            TaskPriority.HIGH->{
//                priority.text = "High priority"
//                lowPrioImg.visibility=View.GONE
//                mediumPrioImg.visibility=View.GONE
//                highPrioImg.visibility=View.VISIBLE
//            }
//        }
        description = requireView().findViewById(R.id.descriptionText)
        description.text= task.description
        backButton = requireView().findViewById(R.id.backButton)
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = requireFragmentManager()
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout4,fragment)
        fragmentTransaction.commit()
    }

}