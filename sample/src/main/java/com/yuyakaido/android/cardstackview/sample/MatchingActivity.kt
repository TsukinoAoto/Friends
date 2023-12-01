package com.yuyakaido.android.cardstackview.sample


import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.UserManager
import android.util.Log
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DiffUtil
import com.google.android.material.navigation.NavigationView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.GenericTypeIndicator
import com.google.firebase.database.ValueEventListener
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.CardStackView
import com.yuyakaido.android.cardstackview.Direction
import com.yuyakaido.android.cardstackview.Duration
import com.yuyakaido.android.cardstackview.RewindAnimationSetting
import com.yuyakaido.android.cardstackview.StackFrom
import com.yuyakaido.android.cardstackview.SwipeAnimationSetting
import com.yuyakaido.android.cardstackview.SwipeableMethod
import java.util.Base64
import java.util.concurrent.CompletableFuture


class MatchingActivity : AppCompatActivity(), CardStackListener {


    private val drawerLayout by lazy { findViewById<DrawerLayout>(R.id.drawer_layout) }
    private val cardStackView by lazy { findViewById<CardStackView>(R.id.card_stack_view) }
    private val manager by lazy { CardStackLayoutManager(this, this) }
    private val adapter by lazy { CardStackAdapter(createSpots()) }


    private var nameDatabase = ""
    private var departmentDatabase = ""
    private var subjectDatabase = ""
    private var gradeDatabase = ""
    private var genderDatabase = ""
    private var groupDatabase = ""
    private var introductionDatabase = ""
    private var hobbiesDatabase: ArrayList<String>? = null
    private var imageBase64Database= ""
    private var numberDatabase= ""
    private var bmp: Bitmap? = null




    //ユーザーひとり一人のプロフィール情報を格納するクラス　Arraylistにこのクラスを格納する
    class UserProfile(
        var id:String="",
        var name:String="",
        var department:String="",
        var subject:String="",
        var grade:String="",
        var gender:String="",
        var group:String="",
        var introduction:String="",
        var hobbies: ArrayList<String>? = null,
        var imageBase64:String="",
        //var number:Int=0,
        var bmp: Bitmap?= null
    )


    private var UserManagement:ArrayList<UserProfile> = ArrayList()


    //id name department subject grade gender group introduction hobbies imageBase64 number bmp


    private var user_id:ArrayList<String> = ArrayList()


    //val myApp: MyApp? = application as? MyApp
    private var userprofiledata = UserProfileData()
    //val myApp = application as? MyApp




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matching)
        setupNavigation()
        setupCardStackView()
        setupButton()


        /*
        // Firebaseからデータを取得するコードを追加
        var databaseReference00 = FirebaseDatabase.getInstance().getReference("Profile")
        databaseReference00.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                /*
                val intentG = intent
                val gmail: String = intentG.getStringExtra("gmail") ?: ""


                for (childSnapshot in snapshot.children){
                    val data: String? = childSnapshot.key
                    if (data != null && data!=gmail){    //data != null && data!=gmail
                        user_id.add(data)
                    }
                }
                for (item in user_id) {
                    Log.d("ユーザー", item)
                }


                 */
            }


            override fun onCancelled(error: DatabaseError) {
                // エラーハンドリングを追加する場合、ここにコードを追加します
            }
        })


         */


        val btComment = findViewById<ImageButton>(R.id.bt_comment)
        btComment.setOnClickListener { finish() }




        /*
        var databaseReference_All = FirebaseDatabase.getInstance().getReference("Profile")
        databaseReference_All.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val intentG = intent
                val gmail: String = intentG.getStringExtra("gmail") ?: ""


                for (childSnapshot in snapshot.children){
                    val data: String? = childSnapshot.key
                    if (data != null && data!=gmail){    //data != null && data!=gmail
                        user_id.add(data)
                    }
                }
                for (item in user_id) {
                    Log.d("ユーザー", item)
                }


                for(userid in user_id){
                    var bmp_dummy: Bitmap?= null
                    var imageBase64_dummy = snapshot.child(userid).child("Base64Image").getValue(String::class.java)?:""
                    if (imageBase64_dummy.isNotBlank()) {
                        val decodeImg = Base64.getDecoder().decode(imageBase64_dummy)
                        bmp_dummy = BitmapFactory.decodeByteArray(decodeImg, 0, decodeImg.size)


                        // ここで bmp を使用できます
                    }


                    /*
                    Log.d("","")
                    Log.d(userid,userid)
                    Log.d(userid + "name",snapshot.child(userid).child("name").getValue(String::class.java)?:"")
                    Log.d(userid + "depa",snapshot.child(userid).child("department").getValue(String::class.java)?:"")
                    Log.d(userid + "sub",snapshot.child(userid).child("subject").getValue(String::class.java)?:"")
                    Log.d(userid + "grade",snapshot.child(userid).child("grade").getValue(String::class.java)?:"")
                    Log.d(userid + "gen",snapshot.child(userid).child("gender").getValue(String::class.java)?:"")
                    Log.d(userid + "group",snapshot.child(userid).child("group").getValue(String::class.java)?:"")
                    Log.d(userid + "intro",snapshot.child(userid).child("introduction").getValue(String::class.java)?:"")
                    Log.d(userid + "bmp",bmp_dummy.toString())
                    Log.d("","")


                     */


                    var user = UserProfile(
                        //id name department subject grade gender group introduction hobbies imageBase64 number bmp
                        userid.toString(),
                        snapshot.child(userid).child("name").getValue(String::class.java)?:"",
                        snapshot.child(userid).child("department").getValue(String::class.java)?:"",
                        snapshot.child(userid).child("subject").getValue(String::class.java)?:"",
                        snapshot.child(userid).child("grade").getValue(String::class.java)?:"",
                        snapshot.child(userid).child("gender").getValue(String::class.java)?:"",
                        snapshot.child(userid).child("group").getValue(String::class.java)?:"",
                        snapshot.child(userid).child("introduction").getValue(String::class.java)?:"",
                        snapshot.child(userid).child("hobbies").getValue(object : GenericTypeIndicator<ArrayList<String>>() {}) ?: ArrayList(),
                        snapshot.child(userid).child("Base64Image").getValue(String::class.java)?:"",
                        //snapshot.child(userid).child("number").getValue(Int::class.java)?:0,
                        bmp_dummy
                        )
                    UserManagement.add(user)
                }
            }


            override fun onCancelled(error: DatabaseError) {
            }




        })


         */




        // Firebaseからデータを取得するコードを追加
        var databaseReference = FirebaseDatabase.getInstance().getReference("Profile").child("2157145")
        databaseReference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // データベースから値を取得し、適切な変数に代入するコードをここに追加します
                nameDatabase = snapshot.child("name").getValue(String::class.java) ?: ""
                genderDatabase = snapshot.child("gender").getValue(String::class.java) ?: ""
                gradeDatabase = snapshot.child("grade").getValue(String::class.java) ?: ""
                groupDatabase = snapshot.child("group").getValue(String::class.java) ?: ""
                departmentDatabase = snapshot.child("department").getValue(String::class.java) ?: ""
                subjectDatabase = snapshot.child("subject").getValue(String::class.java) ?: ""
                introductionDatabase = snapshot.child("introduction").getValue(String::class.java) ?: ""
                hobbiesDatabase = snapshot.child("hobbies").getValue(object : GenericTypeIndicator<ArrayList<String>>() {}) ?: ArrayList()
                //ウクライナに平和
                val base64ImageValue = snapshot.child("Base64Image").getValue(String::class.java)
                if (base64ImageValue != null) {
                    imageBase64Database = base64ImageValue
                }
                numberDatabase = snapshot.child("number").getValue(String::class.java)?:""


                if (imageBase64Database.isNotBlank()) {
                    val decodeImg = Base64.getDecoder().decode(imageBase64Database)
                    bmp = BitmapFactory.decodeByteArray(decodeImg, 0, decodeImg.size)


                    // ここで bmp を使用できます
                }
                // データを処理した後、適切なコンポーネントに反映するコードを追加します
                updateUIWithDatabaseValues()
            }


            override fun onCancelled(error: DatabaseError) {
                // エラーハンドリングを追加する場合、ここにコードを追加します
            }
        })






        val intent = Intent(this, MatchingNextActivity::class.java)


        Log.d("テスト","point1")
        userprofiledata?.show()
    }








    // データベースから取得した値をUIコンポーネントに反映する関数
    private fun updateUIWithDatabaseValues() {
        // ここにデータベースから取得した値をUIコンポーネントに反映するコードを追加します
        // 例えば、TextViewやImageViewにデータをセットするなど
    }


    override fun onBackPressed() {
        Log.d("テスト","point2")
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers()
        } else {
            super.onBackPressed()
        }
    }


    override fun onCardDragging(direction: Direction, ratio: Float) {
        Log.d("テスト","point3")
        Log.d("CardStackView", "onCardDragging: d = ${direction.name}, r = $ratio")
    }


    override fun onCardSwiped(direction: Direction) {
        //カードがスワイプされたときの処理----------------------------------------------------------------------------------------
        Log.d("テスト","point4")
        Log.d("CardStackView", "onCardSwiped: p = ${manager.topPosition}, d = $direction")
        if (manager.topPosition == adapter.itemCount - 5) {
            paginate()
        }
    }


    override fun onCardRewound() {
        Log.d("テスト","point5")
        Log.d("CardStackView", "onCardRewound: ${manager.topPosition}")
    }


    override fun onCardCanceled() {
        Log.d("テスト","point6")
        Log.d("CardStackView", "onCardCanceled: ${manager.topPosition}")
    }


    override fun onCardAppeared(view: View, position: Int) {
        //カードが作られる処理
        Log.d("テスト","point7")
        val textView = view.findViewById<TextView>(R.id.item_name)
        Log.d("CardStackView", "onCardAppeared: ($position) ${textView.text}")
    }


    override fun onCardDisappeared(view: View, position: Int) {
        //カードが消える瞬間の処理が実行されている？
        Log.d("テスト","point8")
        val textView = view.findViewById<TextView>(R.id.item_name)
        Log.d("CardStackView", "onCardDisappeared: ($position) ${textView.text}")
    }


    private fun setupNavigation() {


        //マッチングアクティビティに入ると一番最初に実行されるーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
        Log.d("テスト","point9")
        // Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)


        val intentG = intent
        val gmail: String = intentG.getStringExtra("gmail") ?: ""


        //userprofiledata = (UserProfileData)
        userprofiledata = application as UserProfileData


        userprofiledata?.show()


        //UserManagement = intent.getSerializableExtra("UserManagement")as? ArrayList<UserManagement>






        // DrawerLayout
        val actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer)
        actionBarDrawerToggle.syncState()
        drawerLayout.addDrawerListener(actionBarDrawerToggle)


        // NavigationView
        val navigationView = findViewById<NavigationView>(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.reload -> reload()
                R.id.add_spot_to_first -> addFirst(1)
                R.id.add_spot_to_last -> addLast(1)
                R.id.remove_spot_from_first -> removeFirst(1)
                R.id.remove_spot_from_last -> removeLast(1)
                R.id.replace_first_spot -> replace()
                R.id.swap_first_for_last -> swap()
            }
            drawerLayout.closeDrawers()
            true
        }
    }




    private fun setupCardStackView() {
        Log.d("テスト","point10")
        initialize()
    }


    private fun setupButton() {
        Log.d("テスト","point11")
        val skip = findViewById<View>(R.id.skip_button)
        skip.setOnClickListener {
            val setting = SwipeAnimationSetting.Builder()
                .setDirection(Direction.Left)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(AccelerateInterpolator())
                .build()
            manager.setSwipeAnimationSetting(setting)
            cardStackView.swipe()
        }


        val rewind = findViewById<View>(R.id.rewind_button)
        rewind.setOnClickListener {
            val setting = RewindAnimationSetting.Builder()
                .setDirection(Direction.Bottom)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(DecelerateInterpolator())
                .build()
            manager.setRewindAnimationSetting(setting)
            cardStackView.rewind()
        }


        val like = findViewById<View>(R.id.like_button)
        like.setOnClickListener {
            val setting = SwipeAnimationSetting.Builder()
                .setDirection(Direction.Right)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(AccelerateInterpolator())
                .build()
            manager.setSwipeAnimationSetting(setting)
            cardStackView.swipe()
        }
    }


    private fun initialize() {
        Log.d("テスト","point12")
        manager.setStackFrom(StackFrom.None)
        manager.setVisibleCount(3)
        manager.setTranslationInterval(8.0f)
        manager.setScaleInterval(0.95f)
        manager.setSwipeThreshold(0.3f)
        manager.setMaxDegree(20.0f)
        manager.setDirections(Direction.HORIZONTAL)
        manager.setCanScrollHorizontal(true)
        manager.setCanScrollVertical(true)
        manager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
        manager.setOverlayInterpolator(LinearInterpolator())
        cardStackView.layoutManager = manager
        cardStackView.adapter = adapter
        cardStackView.itemAnimator.apply {
            if (this is DefaultItemAnimator) {
                supportsChangeAnimations = false
            }
        }
    }


    private fun paginate() {
        Log.d("テスト","point13")
        val old = adapter.getSpots()
        val new = old.plus(createSpots())
        val callback = SpotDiffCallback(old, new)
        val result = DiffUtil.calculateDiff(callback)
        adapter.setSpots(new)
        result.dispatchUpdatesTo(adapter)
    }
    private fun reload() {
        Log.d("テスト","point14")
        val old = adapter.getSpots()
        val new = createSpots()
        val callback = SpotDiffCallback(old, new)
        val result = DiffUtil.calculateDiff(callback)
        adapter.setSpots(new)
        result.dispatchUpdatesTo(adapter)
    }


    private fun addFirst(size: Int) {
        Log.d("テスト","point15")
        val old = adapter.getSpots()
        val new = mutableListOf<Spot>().apply {
            addAll(old)
            for (i in 0 until size) {
                add(manager.topPosition, createSpot())
            }
        }
        val callback = SpotDiffCallback(old, new)
        val result = DiffUtil.calculateDiff(callback)
        adapter.setSpots(new)
        result.dispatchUpdatesTo(adapter)
    }


    private fun addLast(size: Int) {
        Log.d("テスト","point16")
        val old = adapter.getSpots()
        val new = mutableListOf<Spot>().apply {
            addAll(old)
            addAll(List(size) { createSpot() })
        }
        val callback = SpotDiffCallback(old, new)
        val result = DiffUtil.calculateDiff(callback)
        adapter.setSpots(new)
        result.dispatchUpdatesTo(adapter)
    }


    private fun removeFirst(size: Int) {
        Log.d("テスト","point17")
        if (adapter.getSpots().isEmpty()) {
            return
        }


        val old = adapter.getSpots()
        val new = mutableListOf<Spot>().apply {
            addAll(old)
            for (i in 0 until size) {
                removeAt(manager.topPosition)
            }
        }
        val callback = SpotDiffCallback(old, new)
        val result = DiffUtil.calculateDiff(callback)
        adapter.setSpots(new)
        result.dispatchUpdatesTo(adapter)
    }


    private fun removeLast(size: Int) {
        Log.d("テスト","point18")
        if (adapter.getSpots().isEmpty()) {
            return
        }


        val old = adapter.getSpots()
        val new = mutableListOf<Spot>().apply {
            addAll(old)
            for (i in 0 until size) {
                removeAt(this.size - 1)
            }
        }
        val callback = SpotDiffCallback(old, new)
        val result = DiffUtil.calculateDiff(callback)
        adapter.setSpots(new)
        result.dispatchUpdatesTo(adapter)
    }


    private fun replace() {
        Log.d("テスト","point19")
        val old = adapter.getSpots()
        val new = mutableListOf<Spot>().apply {
            addAll(old)
            removeAt(manager.topPosition)
            add(manager.topPosition, createSpot())
        }
        adapter.setSpots(new)
        adapter.notifyItemChanged(manager.topPosition)
    }


    private fun swap() {
        Log.d("テスト","point20")
        val old = adapter.getSpots()
        val new = mutableListOf<Spot>().apply {
            addAll(old)
            val first = removeAt(manager.topPosition)
            val last = removeAt(this.size - 1)
            add(manager.topPosition, last)
            add(first)
        }
        val callback = SpotDiffCallback(old, new)
        val result = DiffUtil.calculateDiff(callback)
        adapter.setSpots(new)
        result.dispatchUpdatesTo(adapter)
    }


    private fun createSpot(): Spot {
        Log.d("テスト","point21")
        return Spot(
            name = "Yasaka Shrine",
            city = "Kyoto",
            url = bmp,
            id = ""
        )
    }




    private fun createSpots(): List<Spot> {
        Log.d("テスト","point22")
        userprofiledata.show()


        val spots = ArrayList<Spot>()

        Log.d("",userprofiledata.getID(1))

        for (i in 0 until userprofiledata.useNum -1) {
            spots.add(Spot(name = userprofiledata.getNAME(i), city = userprofiledata.getDEPARTMENT(i) + userprofiledata.getSUBJECT(i) + userprofiledata.getGRADE(i) + userprofiledata.getGROUP(i), url = userprofiledata.getBMP(i),id=userprofiledata.getID(i)))
        }

        // リストをシャッフルしてランダムな順序にする
        spots.shuffle()
        return spots
    }
}
