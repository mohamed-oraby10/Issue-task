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

@Composable
fun IssueItem(modifier: Modifier = Modifier) {
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
                    text = "Issue name")
                Text(text = "Open")
            }
            Text(text = "NONE" )
            Text(text = "Created At: creation date" )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewIssueItem() {
    IssuesAppTheme {
        IssueItem()
    }

}