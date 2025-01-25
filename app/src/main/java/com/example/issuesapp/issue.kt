package com.example.issuesapp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.issuesapp.ui.theme.IssuesAppTheme
import androidx.compose.material.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun IssuesScreen(modifier: Modifier = Modifier) {
    val issues = listOf(
        Issue("Bump pyarrow from 7...", "2023-11-09, 23:00 PM"),
        Issue("Français", "2023-11-02, 9:38 AM"),
        Issue("Bump werkzeug from ...",  "2023-10-25, 18:52 PM"),
        Issue("Bump urllib3 from 1.2...",  "2023-10-17, 22:59 PM"),
        Issue("ORQA fine tuning with...",  "2023-10-09, 15:30 PM"),
        Issue("Bump pillow from 9.2...", "2023-10-04, 00:35 AM")
    )

    Scaffold(
        topBar = {
            TopAppBar(

                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "Issues",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {

                    }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                backgroundColor = Color.White,
                contentColor = Color.Black
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFFF5F5F5)) // خلفية رمادية فاتحة
        ) {
            items(issues) { issue ->
                IssueCard(issue)
            }
        }
    }

}

@Composable
fun IssueCard(issue: Issue) {
    Row(Modifier.fillMaxWidth()
        .padding(horizontal = 8.dp)
        .padding(top = 16.dp)
        .background(color = Color.White,
            shape = RoundedCornerShape(12.dp)
        ).clickable {  },

        )
    {
        Image(
            modifier = Modifier.size(60.dp)
            , painter = painterResource(R.drawable.box) ,
            contentDescription = null )
        Column(
            Modifier.padding(10.dp)
        ) {
            Row {
                Text(modifier = Modifier.weight(1F),
                    text = issue.title)
                Text(text = "Open")
            }
            Text(text = "NONE"  )
            Text(text = "Created At: ${issue.createdAt}" )
        }
    }
}

data class Issue(val title: String, val createdAt: String)

@Preview(showBackground = true)
@Composable
private fun PreviewIssuesScreen() {
    IssuesAppTheme {
        IssuesScreen()
    }

}